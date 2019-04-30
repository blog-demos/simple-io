package simple.io.reactor.client;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:13 2019/03/20
 */
public class ReactorClientApplication {

    public static void main(String[] args) {
        ClientProxy proxy = new ClientProxy();
        proxy.start();
    }
}
