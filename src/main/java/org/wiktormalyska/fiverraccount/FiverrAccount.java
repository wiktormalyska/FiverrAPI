package org.wiktormalyska.fiverraccount;


import lombok.Getter;
import org.wiktormalyska.fiverraccount.connection.FiverrConnection;
import org.wiktormalyska.fiverraccount.data.AccountData;

/**
 * FiverrAPI Profile Scraper.
 *
 * @author Wiktor Małyska.
 * @version 1.0.
 * This class represents a Fiverr account.
 */
public class FiverrAccount {
    /**
     * FiverrAccount is a class that represents a Fiverr account.
     */

    //Setup
    /**
     * The account username.
     */
    @Getter
    private final String username;
    /**
     * The account data of the Fiverr account.
     */
    @Getter
    AccountData accountData;

    /**
     * Instantiates a new Fiverr account.
     *
     * @param username Username of the Fiverr account.
     */
    public FiverrAccount(String username) {
        this.username = username;
        FiverrConnection connection = new FiverrConnection(username);

        accountData = new AccountData(connection);
    }

}
