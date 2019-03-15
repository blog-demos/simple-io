package simple.io.nio.client;

import simple.io.IOTools;
import simple.io.SocketConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author: Q-WHai
 * @Date: Created in 18:37 2019/03/14
 */
public class ClientRunnable implements Runnable {

    private Thread thread;

    public void start() {
        if (null != thread) return;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        InetSocketAddress address = new InetSocketAddress(SocketConfig.DOMAIN, SocketConfig.PORT);
        SocketChannel sc = null;
        ByteBuffer buffer = ByteBuffer.allocate(16);
        try {
            sc = SocketChannel.open();
            sc.connect(address);
            while (true) {
                byte[] bytes = IOTools.randomByteArray(16);
                buffer.put(bytes);
                buffer.flip();
                sc.write(buffer);
                buffer.clear();

                IOTools.output(bytes);

                Thread.sleep(50);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
