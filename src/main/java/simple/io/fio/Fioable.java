package simple.io.fio;

import java.io.IOException;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:50 2019/04/30
 */
public interface Fioable {

    String read(String path) throws IOException;
    void write(String path, String content) throws IOException;
}
