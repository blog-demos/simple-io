package simple.io;

import org.apache.log4j.Logger;
import org.junit.Test;
import simple.io.fio.*;

import java.io.IOException;

/**
 * @Author: Q-WHai
 * @Date: Created in 15:18 2019/04/30
 */
public class FileIOTest {

    private final Logger logger = Logger.getLogger(FileIOTest.class);

    @Test
    public void test1() {
        String path = "H:/io.txt";
        String text = "Java语言中字符串类型和字节数组类型相互之间的转换经常发生，网上的分析及代码也比较多，本文将分析总结常规的byte[]和String间的转换以及十六进制String和byte[]间相互转换的原理及实现。";

        Fioable io = new FileioByBytes();
        try {
            io.write(path, text);

            String content = io.read(path);
            logger.info(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test2() {
        String path = "H:/io.txt";
        String text = "Java语言中字符串类型和字节数组类型相互之间的转换经常发生，网上的分析及代码也比较多，本文将分析总结常规的byte[]和String间的转换以及十六进制String和byte[]间相互转换的原理及实现。";

        Fioable io = new FileioByBuffer();
        try {
            io.write(path, text);

            String content = io.read(path);
            logger.info(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test3() {
        String path = "H:/io.txt";
        String text = "Java语言中字符串类型和字节数组类型相互之间的转换经常发生，网上的分析及代码也比较多，本文将分析总结常规的byte[]和String间的转换以及十六进制String和byte[]间相互转换的原理及实现。";

        Fioable io = new FileioBySingleByte();
        try {
            io.write(path, text);

            String content = io.read(path);
            logger.info(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test4() {
        String path = "H:/io.txt";
        String text = "Java语言中字符串类型和字节数组类型相互之间的转换经常发生，网上的分析及代码也比较多，本文将分析总结常规的byte[]和String间的转换以及十六进制String和byte[]间相互转换的原理及实现。";

        Fioable io = new FileioByLine();
        try {
            io.write(path, text);

            String content = io.read(path);
            logger.info(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void test5() {
        String path = "H:/io.txt";
        String text = "Java语言中字符串类型和字节数组类型相互之间的转换经常发生，网上的分析及代码也比较多，本文将分析总结常规的byte[]和String间的转换以及十六进制String和byte[]间相互转换的原理及实现。";

        Fioable io = new FileioByReader();
        try {
            io.write(path, text);

            String content = io.read(path);
            logger.info(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
