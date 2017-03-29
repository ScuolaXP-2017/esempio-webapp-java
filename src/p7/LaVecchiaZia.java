package p7;

import org.eclipse.jetty.server.Server;

public class LaVecchiaZia {
    public void start() throws Exception {
        Server server = new Server(8080);
        server.setHandler(new Handler());
        server.start();

    }
}
