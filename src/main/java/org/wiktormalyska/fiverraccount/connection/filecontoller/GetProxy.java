package org.wiktormalyska.fiverraccount.connection.filecontoller;

import lombok.SneakyThrows;
import org.wiktormalyska.fiverraccount.connection.FiverrProxy;

import java.io.File;
import java.util.*;

public class GetProxy {
    protected final List<FiverrProxy> proxies;
    Scanner scanner;
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
    public FiverrProxy getProxy(int number){
        return proxies.get(number);
    }
}
