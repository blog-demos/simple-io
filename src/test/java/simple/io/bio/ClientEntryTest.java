package simple.io.bio;

import org.junit.Test;
import simple.io.bio.client.ClientSocketProxy;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:19 2019/03/13
 */
public class ClientEntryTest {

    @Test
    public void test1() {
        ClientSocketProxy proxy = new ClientSocketProxy();
        proxy.start();
    }
}
