package simple.io;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * @Author: Q-WHai
 * @Date: Created in 11:03 2019/03/15
 */
public class IOTools {

    private static final Logger logger = Logger.getLogger(IOTools.class);

    public static void output(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("0x%02x ", b));
        }

        logger.info(String.format("[%s]", sb.toString()));
    }

    public static byte[] randomByteArray(int length) {
        byte[] data = new byte[length];
        Random random = new Random();
        for (int i = length - 1; i >= 0; i--) {
            data[i] = (byte)random.nextInt(Byte.MAX_VALUE);
        }

        return data;
    }
}
