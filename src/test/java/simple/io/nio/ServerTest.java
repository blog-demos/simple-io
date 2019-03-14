package simple.io.nio;

import org.junit.Test;
import simple.io.nio.server.ServerSocketProxy;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:43 2019/03/14
 */
public class ServerTest {

    @Test
    public void test1() {
        ServerSocketProxy proxy = new ServerSocketProxy();
        proxy.start();
    }
}
