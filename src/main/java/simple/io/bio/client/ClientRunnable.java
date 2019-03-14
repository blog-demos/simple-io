package simple.io.bio.client;

import simple.io.SocketConfig;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:15 2019/03/14
 */
public class ClientRunnable implements Runnable {

    private Thread thread;

    @Override
    public void run() {
        try {
            byte[] data = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F };

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

    void start() {
        if (null != thread) return;

        thread = new Thread(this);
        thread.start();
    }
}
