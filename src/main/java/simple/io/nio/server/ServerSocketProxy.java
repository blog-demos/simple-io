package simple.io.nio.server;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:42 2019/03/14
 */
public class ServerSocketProxy {

    public void start() {
        ServerRunnable server = new ServerRunnable(8379);
        server.start();
    }
}
