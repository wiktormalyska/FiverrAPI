package org.wiktormalyska.fiverraccount;


import lombok.Getter;
import org.wiktormalyska.fiverraccount.data.AccountData;

import java.util.logging.Logger;

public class FiverrAccount {
    public static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //Setup
    @Getter
    private final String username;
    @Getter
    AccountData accountData;

    public FiverrAccount(String username) {
        this.username = username;
        FiverrConnection connection = new FiverrConnection(username);

        accountData = new AccountData(username, connection);
    }

}
