package org.wiktormalyska.fiverraccount.connection.filecontoller;

import lombok.SneakyThrows;
import org.wiktormalyska.fiverraccount.connection.FiverrProxy;

import java.io.File;
import java.util.*;

/**
 * This class represents a Proxy on Fiverr.
 */
public class GetProxy {
    /**
     * The list of proxies.
     */
    protected final List<FiverrProxy> proxies;
    /**
     * The scanner.
     */
    Scanner scanner;

    /**
     * This method gets a proxy from the proxy list.
     */
    @SneakyThrows
    public GetProxy(){
        proxies = new ArrayList<>();
        File proxyList = new File("src/main/java/org/wiktormalyska/fiverraccount/connection/proxylist.txt");
        scanner = new Scanner(proxyList);
        while (scanner.hasNextLine()){
            String read = scanner.nextLine();
            if (read.isEmpty()) continue;
            if (read.charAt(0)=='#') continue;
            read = read.replace("http://", "");
            String[] proxy = read.split(":");
            proxies.add(new FiverrProxy(proxy[0], Integer.parseInt(proxy[1])));
        }
    }

    /**
     * This method gets a proxy from the proxy list.
     * @param number The number of the proxy in list.
     * @return The proxy.
     */
    public FiverrProxy getProxy(int number){
        return proxies.get(number);
    }
}
