package simple.io.bio.server;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:05 2019/03/20
 */
public class BIOServerApplication {

    public static void main(String[] args) {
        ServerSocketProxy server = new ServerSocketProxy();
        server.start();
    }
}
