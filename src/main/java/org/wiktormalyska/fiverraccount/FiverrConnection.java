package org.wiktormalyska.fiverraccount;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FiverrConnection {
    String username;
    @Getter
    Document website;
    public FiverrConnection(String username) {
        this.username = username;
        connect();
    }

    public void connect(){
        try {
            website = Jsoup.connect("https://www.fiverr.com/"+username)
                    .userAgent("Mozilla")
                    .get();
        } catch (Exception e) {
            FiverrAccount.log.warning("Connection Error: "+e.getMessage());
        }
    }
}
