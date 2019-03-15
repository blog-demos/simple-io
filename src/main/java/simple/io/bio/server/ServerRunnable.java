package simple.io.bio.server;

import org.apache.log4j.Logger;
import simple.io.IOTools;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:15 2019/03/13
 */
public class ServerRunnable implements Runnable {

    private final Logger logger = Logger.getLogger(ServerRunnable.class);
    private Thread thread;
    private Socket socket;

    ServerRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            byte[] data = new byte[16];
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            dis.read(data);

            dis.close();
            IOTools.output(data);
            socket.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }



    void start() {
        if (null == thread) {
            thread = new Thread(this);
            thread.start();
        }
    }
}
