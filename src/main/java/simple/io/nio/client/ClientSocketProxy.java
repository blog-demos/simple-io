package simple.io.nio.client;

import java.io.IOException;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:37 2019/03/14
 */
public class ClientSocketProxy {

    public void start() {
        ClientRunnable client = new ClientRunnable();
        client.start();
    }
}
