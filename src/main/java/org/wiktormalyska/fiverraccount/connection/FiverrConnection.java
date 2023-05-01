package org.wiktormalyska.fiverraccount.connection;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.wiktormalyska.fiverraccount.connection.filecontoller.GetProxy;

public class FiverrConnection {
    final String username;
    @Getter
    Document website;
    FiverrProxy proxy;
    final GetProxy getProxy = new GetProxy();
    public FiverrConnection(String username) {
        this.username = username;
        connect(0, false);
    }

    public void connect(int number, Boolean useProxy){
        if (useProxy) {
            proxy = getProxy.getProxy(number);
            try {
                website = Jsoup.connect("https://www.fiverr.com/" + username)
                        .userAgent("Chrome")
                        .proxy(proxy.ip, proxy.port)
                        .header("Content-Language", "en-US")
                        .timeout(16000)
                        .get();
            } catch (Exception e) {
                System.out.println("Proxy " + proxy.ip + ":" + proxy.port + " is not working");
                connect(number + 1, true);
            }
        } else {
            try {
                website = Jsoup.connect("https://www.fiverr.com/" + username)
                        .userAgent("Chrome")
                        .header("Content-Language", "en-US")
                        .timeout(8000)
                        .get();
            } catch (Exception e) {
                System.out.println("Local connection is not working");
                connect(0, true);
            }
        }
    }
}
