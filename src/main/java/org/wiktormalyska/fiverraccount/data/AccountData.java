package org.wiktormalyska.fiverraccount.data;

import lombok.AllArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wiktormalyska.fiverraccount.connection.FiverrConnection;
import org.wiktormalyska.fiverraccount.data.type.Gig;
import org.wiktormalyska.fiverraccount.data.type.Language;
import org.wiktormalyska.fiverraccount.data.type.Rating;
import org.wiktormalyska.fiverraccount.data.type.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class AccountData {

    private final Document website;

    public AccountData(FiverrConnection connection) {
        this.website = connection.getWebsite();
    }


    public String getFullName(){
        Element fullNameElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div/b[1]").first();
        return Objects.requireNonNull(fullNameElement).text();
    }

    public Boolean getIsOnline(){
        Element isOnlineElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/div").first();
        return Objects.requireNonNull(isOnlineElement).text().equals("·Online");
    }

    public String getShortDescription(){
        Element shortDescriptionElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/span").first();
        return Objects.requireNonNull(shortDescriptionElement).text();
    }

    public String getLongDescription(){
        Element longDescriptionElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/p").first();
        return Objects.requireNonNull(longDescriptionElement).text();
    }

    public int getNumberOfReviews(){
        Element numberOfReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div/span").first();
        return Integer.parseInt(Objects.requireNonNull(numberOfReviewsElement).text().replace("reviews", "").replace("(","").replace(")","").replace(" ",""));
    }

    public String getLocation(){
        Element locationElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[5]/ul/li[1]/b").first();
        return Objects.requireNonNull(locationElement).text();
    }

    public String getMemberSince(){
        Element memberSinceElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[5]/ul/li[2]/b").first();
        return Objects.requireNonNull(memberSinceElement).text();
    }

    public String getAverageResponseTime(){
        Element avgResponseTimeElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[5]/ul/li[3]/b").first();
        return Objects.requireNonNull(avgResponseTimeElement).text();
    }

    public String getLastDelivery(){
        Elements lastDeliveryElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[5]/ul/li[4]/strong");
        Element lastDeliveryNumberElement = lastDeliveryElement.first();
        return Objects.requireNonNull(lastDeliveryNumberElement).text();
    }

    public List<Language> getLanguages(){
        Element languagesMainElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[2]/ul").first();
        Elements languagesElements = Objects.requireNonNull(languagesMainElement).children();
        List<Language> languagesList = new ArrayList<>();
        for (Element languageElement : languagesElements){
            String language = languageElement.text().substring(0, languageElement.text().indexOf(" "));
            String level = languageElement.text().substring(languageElement.text().indexOf("- ")+1);
            languagesList.add(new Language(language, level));
        }

        return languagesList;
    }

    public List<String> getLinkedAccounts(){
        List<String> linkedAccountsList = new ArrayList<>();
        Elements linkedAccountsElements = website.getElementsByClass("social-account");
        for (Element linkedAccount : linkedAccountsElements){
            linkedAccountsList.add(linkedAccount.text());
        }
        return linkedAccountsList;
    }

    public List<String> getSkills(){
        List<String> skillsList = new ArrayList<>();
        Elements skillsElements = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[4]/ul");
        for (Element skill : skillsElements){
            skillsList.add(skill.text());
        }
        return skillsList;
    }

    public String getProfilePicture(){
        Elements profilePictureElements = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div/label/img");
        Element profilePictureElement = profilePictureElements.first();
        return Objects.requireNonNull(profilePictureElement).attr("src");
    }

    public int getProfileLevel(){
        Element profileLevelElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div/label/a").first();
        if (Objects.requireNonNull(profileLevelElement).getElementsByClass("level-one-seller").first()!=null){
            return 1;
        } else if (profileLevelElement.getElementsByClass("level-two-seller").first()!=null){
            return 2;
        } else if (profileLevelElement.getElementsByClass("top-rated-seller").first()!=null){
            return 3;
        } else {
            return 0;
        }
    }

    public List<Gig> getGigs(){
        List<Gig> gigsList = new ArrayList<>();
        Elements gigContainer = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/section/div");
        for (Element gig : gigContainer){
            String gigTitle = Objects.requireNonNull(gig.getElementsByTag("h3").first()).text();
            String ratingAndReviews = Objects.requireNonNull(gig.getElementsByClass("gig-rating").first()).text();
            double rating = Double.parseDouble(ratingAndReviews.substring(0,ratingAndReviews.indexOf("(")));
            int numberOfReviews = Integer.parseInt(ratingAndReviews.substring(ratingAndReviews.indexOf("(")).replace("(","").replace(")",""));
            String priceText = Objects.requireNonNull(gig.getElementsByClass("price").first()).text().replace("Starting at", "");
            char currency = '?';
            if (priceText.contains("$")) currency = '$';
            else if (priceText.contains("€")) currency = '€';
            priceText = priceText.replace("€", "").replace("$", "");
            double price = Double.parseDouble(priceText);
            String thumbnail = Objects.requireNonNull(gig.getElementsByTag("img").first()).attr("src");
            gigsList.add(new Gig(gigTitle, rating, numberOfReviews, price, currency, thumbnail));
        }
        return gigsList;
    }

    public Rating getRating(){
        Element overAllRatingElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/header/div/h2/span/div[2]/b").first();
        double overallRating = Double.parseDouble(Objects.requireNonNull(overAllRatingElement).text());
        Element sellerCommunicationLevelElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[2]/div/ul/li[1]/span/div/b").first();
        double sellerCommunicationLevel = Double.parseDouble(Objects.requireNonNull(sellerCommunicationLevelElement).text());
        Element recommendToAFriend = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[2]/div/ul/li[2]/span/div/b").first();
        double recommendToAFriendRating = Double.parseDouble(Objects.requireNonNull(recommendToAFriend).text());
        Element serviceAsDescribedElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[2]/div/ul/li[3]/span/div/b").first();
        double serviceAsDescribed = Double.parseDouble(Objects.requireNonNull(serviceAsDescribedElement).text());

        Element fiveStarReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[1]/table/tbody/tr[1]/td[3]").first();
        int fiveStarReviews = Integer.parseInt(Objects.requireNonNull(fiveStarReviewsElement).text().replace("(", "").replace(")",""));
        Element fourStarReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[1]/table/tbody/tr[2]/td[3]").first();
        int fourStarReviews = Integer.parseInt(Objects.requireNonNull(fourStarReviewsElement).text().replace("(", "").replace(")",""));
        Element threeStarReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[1]/table/tbody/tr[3]/td[3]").first();
        int threeStarReviews = Integer.parseInt(Objects.requireNonNull(threeStarReviewsElement).text().replace("(", "").replace(")",""));
        Element twoStarReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[1]/table/tbody/tr[4]/td[3]").first();
        int twoStarReviews = Integer.parseInt(Objects.requireNonNull(twoStarReviewsElement).text().replace("(", "").replace(")",""));
        Element oneStarReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/span/div[1]/div[1]/table/tbody/tr[5]/td[3]").first();
        int oneStarReviews = Integer.parseInt(Objects.requireNonNull(oneStarReviewsElement).text().replace("(", "").replace(")",""));

        return new Rating(overallRating,sellerCommunicationLevel,recommendToAFriendRating,serviceAsDescribed,fiveStarReviews,fourStarReviews,threeStarReviews,twoStarReviews,oneStarReviews);
    }

    public List<Review> getReviews(){
        List<Review> reviewsList = new ArrayList<>();
        Elements reviewsContainer = website.getElementsByClass("review-list");

        for (Element reviewElement : reviewsContainer) {
            String username = Objects.requireNonNull(reviewElement.getElementsByClass("username").first()).text();
            String userProfileImage = Objects.requireNonNull(reviewElement.getElementsByTag("img").first()).attr("src");
            String country = Objects.requireNonNull(reviewElement.getElementsByClass("country-name").first()).text();
            double rating = Double.parseDouble(Objects.requireNonNull(reviewElement.getElementsByClass("rating-score").first()).text());
            String timeAgo = Objects.requireNonNull(reviewElement.getElementsByTag("time").first()).text();
            String review = Objects.requireNonNull(reviewElement.getElementsByClass("review-description").first()).text();

            reviewsList.add(new Review(username, userProfileImage, country, rating, timeAgo, review));
        }

        return reviewsList;
    }

}
