package org.wiktormalyska.fiverraccount.connection;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents a Proxy on Fiverr.
 */
@AllArgsConstructor
public class FiverrProxy {
     /**
      * The ip of the proxy.
      */
     @Getter
     String ip;
     /**
      * The port of the proxy.
      */
     @Getter
     int port;
}
