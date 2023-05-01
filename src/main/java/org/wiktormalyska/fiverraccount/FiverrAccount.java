package org.wiktormalyska.fiverraccount;


import lombok.Getter;
import org.wiktormalyska.fiverraccount.connection.FiverrConnection;
import org.wiktormalyska.fiverraccount.data.AccountData;

public class FiverrAccount {

    //Setup
    @Getter
    private final String username;
    @Getter
    AccountData accountData;

    public FiverrAccount(String username) {
        this.username = username;
        FiverrConnection connection = new FiverrConnection(username);

        accountData = new AccountData(connection);
    }

}
