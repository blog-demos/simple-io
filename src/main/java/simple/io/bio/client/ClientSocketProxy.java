package simple.io.bio.client;

import org.apache.log4j.Logger;
import simple.io.SocketProxy;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:43 2019/03/13
 */
public class ClientSocketProxy implements SocketProxy {

    private final Logger logger = Logger.getLogger(ClientSocketProxy.class);

    @Override
    public void start() {
        try {
            for (int i = 0; i < 100; i++) {
                ClientRunnable client = new ClientRunnable();

                logger.info(String.format("第 %d 次请求", i + 1));
                client.start();
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
