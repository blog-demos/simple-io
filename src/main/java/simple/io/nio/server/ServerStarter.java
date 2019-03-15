package simple.io.nio.server;

/**
 * @Author: Q-WHai
 * @Date: Created in 10:55 2019/03/15
 */
public class ServerStarter {

    public static void main(String[] args) {
        ServerSocketProxy proxy = new ServerSocketProxy();
        proxy.start();
    }
}
