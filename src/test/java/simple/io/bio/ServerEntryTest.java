package simple.io.bio;

import org.junit.Test;
import simple.io.bio.server.ServerSocketProxy;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:24 2019/03/13
 */
public class ServerEntryTest {

    @Test
    public void test1() {
        ServerSocketProxy server = new ServerSocketProxy();
        server.start();
    }
}
