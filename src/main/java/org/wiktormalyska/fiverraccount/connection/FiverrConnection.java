package org.wiktormalyska.fiverraccount.connection;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.wiktormalyska.fiverraccount.connection.filecontoller.GetProxy;

/**
 * This class represents a connection to Fiverr.
 */
public class FiverrConnection {
    /**
     * The username of the account.
     */
    final String username;
    /**
     * The website of the connection.
     */
    @Getter
    Document website;
    /**
     * The proxy of the connection.
     */
    FiverrProxy proxy;
    /**
     * The GetProxy class.
     */
    final GetProxy getProxy = new GetProxy();

    /**
     * Instantiates a new Fiverr connection.
     * @param username The username of the account.
     */
    public FiverrConnection(String username) {
        this.username = username;
        connect(0, false);
    }

    /**
     * Connects to Fiverr.
     * @param number The number of the proxy in list.
     * @param useProxy If the connection should use a proxy.
     */
    protected void connect(int number, Boolean useProxy){
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
