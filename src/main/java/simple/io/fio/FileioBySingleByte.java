package simple.io.fio;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:56 2019/04/30
 */
public class FileioBySingleByte implements Fioable {

    @Override
    public String read(String path) throws IOException {
        InputStreamReader in = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
        int b = -1;
        StringBuilder sb = new StringBuilder();
        byte[] buff = new byte[1024];
        int index = 0;
        while ((b = in.read()) != -1) {
            buff[index++] = (byte) b;
            if (1024 == index) {
                sb.append(new String(buff, 0, index, StandardCharsets.UTF_8));
                index = 0;
            }
        }

        if (0 != index) sb.append(new String(buff , 0, index, StandardCharsets.UTF_8));
        in.close();

        return sb.toString();
    }

    @Override
    public void write(String path, String content) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path));

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            out.write(b);
        }

        out.flush();
        out.close();
    }
}
