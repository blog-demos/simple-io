package simple.io.reactor.server;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:13 2019/03/20
 */
public class ReactorServerApplication {

    public static void main(String[] args) {
        List<ReactorSocket> sockets = new ArrayList<>();
        SocketAcceptRunnable socketAccepter = new SocketAcceptRunnable(sockets);

        socketAccepter.start();
    }
}
