package simple.io.reactor.client;

import simple.io.SocketConfig;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:02 2019/03/20
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
        try {
            byte[] data = { 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F };

            Socket socket = new Socket(SocketConfig.DOMAIN, SocketConfig.PORT);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.write(data);

            dos.flush();
            dos.close();

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
