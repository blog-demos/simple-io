package simple.io.fio;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:23 2019/04/30
 */
public class FileioByReader implements Fioable {

    @Override
    public String read(String path) throws IOException {
        Reader in = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);

        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int index = 0;
        int data = -1;
        while ((data = in.read()) != -1) {
            bytes[index++] = (byte) data;
            if (1024 == index) {
                sb.append(new String(bytes, 0, index, StandardCharsets.UTF_8));
                index = 0;
            }
        }

        if (0 != index) sb.append(new String(bytes, 0, index, StandardCharsets.UTF_8));

        in.close();
        return sb.toString();
    }

    @Override
    public void write(String path, String content) throws IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8), true);

        //out.write(content);

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        for (byte b : bytes) {
            out.write(b);
        }

        out.flush();
        out.close();
    }
}
