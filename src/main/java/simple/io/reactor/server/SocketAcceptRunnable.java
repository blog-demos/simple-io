package simple.io.reactor.server;

import org.apache.log4j.Logger;
import simple.io.SocketConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

/**
 * @Author: Q-WHai
 * @Date: Created in 17:23 2019/03/20
 */
public class SocketAcceptRunnable implements Runnable {

    private Logger logger = Logger.getLogger(SocketAcceptRunnable.class);
    private List<ReactorSocket> sockets;
    private Thread thread;

    SocketAcceptRunnable(List<ReactorSocket> sockets) {
        this.sockets = sockets;
    }

    public void start() {
        if (null != thread) return;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        do {
            try {
                ServerSocket server = new ServerSocket(SocketConfig.PORT);
                ReactorSocket socket = (ReactorSocket) server.accept();
                logger.info(String.format("Accept Socket: %s:%d", socket.getInetAddress(), socket.getPort()));

                // TODO 添加监听者

                sockets.add(socket);
            } catch (IOException ex) {
                logger.error(ex.getMessage());
                break;
            }
        } while (true);
    }
}
