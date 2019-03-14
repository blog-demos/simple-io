package simple.io.bio.server;

import simple.io.SocketConfig;
import simple.io.bio.SocketProxy;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:06 2019/03/13
 */
public class ServerSocketProxy implements SocketProxy {

    @Override
    public void start() {
        try {
            ServerSocket server = new ServerSocket(SocketConfig.PORT);
            boolean stop = false;
            while (!stop) {
                new ServerRunnable(server.accept()).start();
            }

            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
