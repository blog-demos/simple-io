package simple.io.fio;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:52 2019/04/30
 */
public class FileioByBuffer implements Fioable {

    @Override
    public String read(String path) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));

        byte[] bytes = new byte[2048];
        int n = -1;
        StringBuilder sb = new StringBuilder();
        while ((n = in.read(bytes, 0, bytes.length)) != -1) {
            sb.append(new String(bytes, 0, n, StandardCharsets.UTF_8));
        }

        in.close();

        return sb.toString();
    }

    @Override
    public void write(String path, String content) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < bytes.length; i += 2048) {
            out.write(Arrays.copyOfRange(bytes, i * 2048, Math.min((i + 1) * 2048, bytes.length)));
        }

        out.flush();
        out.close();
    }
}
