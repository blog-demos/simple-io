package simple.io.bio.client;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:05 2019/03/20
 */
public class BIOClientApplication {

    public static void main(String[] args) {
        ClientSocketProxy proxy = new ClientSocketProxy();
        proxy.start();
    }
}
