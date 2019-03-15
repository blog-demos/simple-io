package simple.io.nio.client;

/**
 * @Author: Q-WHai
 * @Date: Created in 10:56 2019/03/15
 */
public class ClientStarter {

    public static void main(String[] args) {
        ClientSocketProxy proxy = new ClientSocketProxy();
        proxy.start();
    }
}
