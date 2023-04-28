// Authors: Wiktor Małyska

import FileManager.FileController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.wiktormalyska.fiverraccount.FiverrAccount;

import java.util.logging.Logger;

import static org.jsoup.helper.Validate.fail;
import static org.junit.jupiter.api.Assertions.*;


public class ConnectionTests {
    private static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    FileController fileController
            = new FileController("src/test/java/TestData/FiverrProfilesNames.txt");

    @Test
    @DisplayName("Test All")
    public void testAll(){
        testFullName();
        testOnline();
        testShortDescription();
        testLongDescription();
    }

    @Test
    @DisplayName("Test reading Full Name from Fiverr Profiles")
    public void testFullName() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getFullName());
        }
    }

    @Test
    @DisplayName("Test getting if Online from Fiverr Profiles")
    public void testOnline() {
        for (FiverrAccount account : fileController.getAccounts()) {
            if (account.getAccountData().getIsOnline()){
                assertTrue(account.getAccountData().getIsOnline());
            }
        }
    }

    @Test
    @DisplayName("Test reading Short Description from Fiverr Profiles")
    public void testShortDescription() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getShortDescription());
        }
    }

    @Test
    @DisplayName("Test reading Long Description from Fiverr Profiles")
    public void testLongDescription() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getLongDescription());
        }
    }

    @Test
    @DisplayName("Test getting Number of Reviews from Fiverr Profiles")
    public void testNumberOfReviews() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotEquals(0,account.getAccountData().getNumberOfReviews());
        }
    }

    @Test
    @DisplayName("Test getting Location from Fiverr Profiles")
    public void testLocation() {
        for (FiverrAccount account : fileController.getAccounts()) {
            assertNotNull(account.getAccountData().getLocation());
        }
    }
}
