package org.wiktormalyska.fiverraccount.data;

import lombok.Getter;
import lombok.NonNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.wiktormalyska.fiverraccount.FiverrAccount;
import org.wiktormalyska.fiverraccount.FiverrConnection;
import org.wiktormalyska.fiverraccount.data.type.Gig;
import org.wiktormalyska.fiverraccount.data.type.Language;
import org.wiktormalyska.fiverraccount.data.type.Rating;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class AccountData {

    private String username;
    private FiverrConnection connection;

    private final Document website;

    public AccountData(String username, FiverrConnection connection) {
        this.username = username;
        this.connection = new FiverrConnection(username);
        this.website = connection.getWebsite();
    }


    public String getFullName(){
        Element fullNameElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div/b[1]").first();
        return fullNameElement.text();
    }

    public Boolean getIsOnline(){
        Element isOnlineElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[1]/div").first();
        return isOnlineElement.text().equals("·Online");
    }

    public String getShortDescription(){
        Element shortDescriptionElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/span").first();
        return shortDescriptionElement.text();
    }

    public String getLongDescription(){
        Element longDescriptionElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/p").first();
        return longDescriptionElement.text();
    }

    public int getNumberOfReviews(){
        Element numberOfReviewsElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div/span").first();
        return Integer.parseInt(numberOfReviewsElement.text().replace("reviews", "").replace("(","").replace(")","").replace(" ",""));
    }

    public String getLocation(){
        Element locationElement = website.selectXpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]/div[5]/ul/li[1]/b").first();
        return locationElement.text();
    }

    public void getMemberSince(){
        //TODO
    }

    public void getAvgResponseTime(){
        //TODO
    }

    public void getLastDelivery(){
        //TODO
    }

    public void getLanguages(){
        //TODO
    }

    public void getLinkedAccounts(){
        //TODO
    }

    public void getSkills(){
        //TODO
    }

    public void getProfilePicture(){
        //TODO
    }

    public void getProfileLevel(){
        //TODO
    }

    public void getGigs(){
        //TODO
    }

    public void getRating(){
        //TODO
    }

}
