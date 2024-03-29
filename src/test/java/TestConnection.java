// Authors: Wiktor Małyska

import filemanager.FileController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wiktormalyska.fiverraccount.FiverrAccount;
import org.wiktormalyska.fiverraccount.data.type.Gig;
import org.wiktormalyska.fiverraccount.data.type.Language;
import org.wiktormalyska.fiverraccount.data.type.Rating;
import org.wiktormalyska.fiverraccount.data.type.Review;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class represents a Test Connection.
 */
public class TestConnection {
    final FileController fileController;

    /**
     * Constructor for TestConnection.
     */
    public TestConnection(){
        fileController
                = new FileController("src/test/java/testdata/FiverrProfilesNames.txt");
    }


    /**
     *  Test reading Full Name from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test reading Full Name from Fiverr Profiles")
    public void testFullName() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getFullName());
        }
    }

    /**
     * Test reading if Online from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test if Online from Fiverr Profiles")
    public void testOnline() {
        for (FiverrAccount account : fileController.getAccounts()) {
            if (account.getAccountData().getIsOnline()){
                assertTrue(account.getAccountData().getIsOnline());
            }
        }
    }


    /**
     * Test reading Short Description from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test reading Short Description from Fiverr Profiles")
    public void testShortDescription() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getShortDescription());
        }
    }

    /**
     * Test reading Long Description from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test reading Long Description from Fiverr Profiles")
    public void testLongDescription() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getLongDescription());
        }
    }

    /**
     * Test reading Number of Reviews from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Number of Reviews from Fiverr Profiles")
    public void testNumberOfReviews() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotEquals(0,account.getAccountData().getNumberOfReviews());
        }
    }

    /**
     * Test reading Location from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Location from Fiverr Profiles")
    public void testLocation() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getLocation());
        }
    }

    /**
     * Test reading Member since from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Member Since from Fiverr Profiles")
    public void testMemberSince() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getMemberSince());
        }
    }

    /**
     * Test reading Average response time from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Average Response Time from Fiverr Profiles")
    public void testAverageResponseTime() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getAverageResponseTime());
        }
    }

    /**
     * Test reading Last delivery from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Last delivery from Fiverr Profiles")
    public void testLastDelivery() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getLastDelivery());
        }
    }

    /**
     * Test reading Languages from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Languages from Fiverr Profiles")
    public void testLanguages() {
        for (FiverrAccount account : fileController.getAccounts()) {
            List<Language> languages = account.getAccountData().getLanguages();
            for (Language language : languages){
                Assertions.assertAll(
                        () -> assertNotNull(language.getLanguage()),
                        () -> assertNotNull(language.getLevel()));
            }

        }
    }

    /**
     * Test reading Linked Accounts from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Linked Accounts from Fiverr Profiles")
    public void testLinkedAccounts(){
        for (FiverrAccount account : fileController.getAccounts()) {
            for (String linkedAccount : account.getAccountData().getLinkedAccounts()){
                assertNotNull(linkedAccount);
            }
        }
    }

    /**
     * Test reading Skills from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Skills from Fiverr Profiles")
    public void testSkills(){
        for (FiverrAccount account : fileController.getAccounts()) {
            for (String skill : account.getAccountData().getSkills()){
                assertNotNull(skill);
            }
        }
    }

    /**
     * Test reading Profile picture from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Profile Picture from Fiverr Profiles")
    public void testProfilePicture(){
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getProfilePicture());
        }
    }

    /**
     * Test reading Profile Level from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Profile Level from Fiverr Profiles")
    public void testProfileLevel(){
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotEquals(0,account.getAccountData().getProfileLevel());
        }
    }

    /**
     * Test reading Gigs from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Gigs from Fiverr Profiles")
    public void  testGigs(){
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotEquals(0,account.getAccountData().getGigs().size());
            for (Gig gig: account.getAccountData().getGigs()){
                assertAll(
                        () -> assertNotNull(gig.getTitle()),
                        () -> assertNotEquals(0,gig.getRatingScore()),
                        () -> assertNotEquals(-1,gig.getNumberOfReviews()),
                        () -> assertNotEquals(0,gig.getStartingPrice()),
                        () -> assertNotEquals('?',gig.getCurrency()),
                        () -> assertNotNull(gig.getThumbnail()));
            }
        }
    }

    /**
     * Test reading Rating from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Rating from Fiverr Profiles")
    public void testRating(){
        for (FiverrAccount account : fileController.getAccounts()) {
            Rating rating = account.getAccountData().getRating();
            assertAll(
                    () -> assertNotEquals(-1,rating.getOverallRatingScore()),
                    () -> assertNotEquals(-1,rating.getSellerCommunication()),
                    () -> assertNotEquals(-1,rating.getRecommendedToAFriend()),
                    () -> assertNotEquals(-1,rating.getServiceAsDescribed()),
                    () -> assertNotEquals(-1,rating.getFiveStarReviews()),
                    () -> assertNotEquals(-1,rating.getFourStarReviews()),
                    () -> assertNotEquals(-1,rating.getThreeStarReviews()),
                    () -> assertNotEquals(-1,rating.getTwoStarReviews()),
                    () -> assertNotEquals(-1,rating.getOneStarReviews()));
        }
    }

    /**
     * Test reading Reviews from Fiverr Profiles.
     */
    @Test
    @DisplayName("Test Reviews from Fiverr Profiles")
    public void testReviews(){
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotEquals(0,account.getAccountData().getReviews().size());
            for (Review review : account.getAccountData().getReviews()){
                assertAll(
                        () -> assertNotNull(review.getUsername()),
                        () -> assertNotNull(review.getUserProfileImage()),
                        () -> assertNotNull(review.getCountry()),
                        () -> assertNotEquals(0,review.getRating()),
                        () -> assertNotNull(review.getTimeAgo()),
                        () -> assertNotNull(review.getReview()));
            }
        }
    }

}
