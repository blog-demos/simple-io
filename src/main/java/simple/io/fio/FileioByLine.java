package simple.io.fio;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Q-WHai
 * @Date: Created in 16:14 2019/04/30
 */
public class FileioByLine implements Fioable {

    @Override
    public String read(String path) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String str;
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while ((str = in.readLine()) != null) {
            sb.append(String.format("%s%s", first ? "" : "\n", str));
            first = false;
        }

        in.close();
        return sb.toString();
    }

    @Override
    public void write(String path, String content) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));

        out.write(content);
        // out.newLine();

        out.flush();
        out.close();
    }
}
