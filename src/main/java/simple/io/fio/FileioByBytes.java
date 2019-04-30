package simple.io.fio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:51 2019/04/30
 */
public class FileioByBytes implements Fioable {

    @Override
    public String read(String path) throws IOException {
        InputStream in = new FileInputStream(path);
        byte[] bytes = new byte[1024]; // 读取缓冲区
        int n = -1;
        StringBuilder sb = new StringBuilder();
        while ((n = in.read(bytes, 0, bytes.length)) != -1) {
            sb.append(new String(bytes,0, n, StandardCharsets.UTF_8));
        }

        in.close();
        return sb.toString();
    }

    @Override
    public void write(String path, String content) throws IOException {
        OutputStream out = new FileOutputStream(path);

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i += 1024) {
            out.write(Arrays.copyOfRange(bytes, i * 1024, Math.min((i + 1) * 1024, bytes.length)));
        }

        out.flush();
        out.close();
    }
}
