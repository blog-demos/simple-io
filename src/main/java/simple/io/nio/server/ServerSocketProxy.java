package simple.io.nio.server;

import simple.io.SocketConfig;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:42 2019/03/14
 */
public class ServerSocketProxy {

    private ServerRunnable server;

    public void start() {
        server = new ServerRunnable(SocketConfig.PORT);
        server.start();
    }
}
