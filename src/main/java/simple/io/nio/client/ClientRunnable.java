package simple.io.nio.client;

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
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8379);
        SocketChannel sc = null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            sc = SocketChannel.open();
            sc.connect(address);
            while (true) {
                byte[] bytes = new byte[1024];
                System.in.read(bytes);
                buffer.put(bytes);
                buffer.flip();
                sc.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
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