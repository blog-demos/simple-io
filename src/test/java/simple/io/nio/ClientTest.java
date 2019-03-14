package simple.io.nio;

import org.junit.Test;
import simple.io.nio.client.ClientSocketProxy;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:39 2019/03/14
 */
public class ClientTest {

    @Test
    public void test1() {
        ClientSocketProxy proxy = new ClientSocketProxy();
        proxy.start();
    }
}
