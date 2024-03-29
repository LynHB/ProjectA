package study.lombok;

import lombok.Cleanup;

import java.io.*;

/**
 * @Author LynHB
 * @Description :
 * @Date 21:03 2020/6/24
 **/
public class CleanupExample {
    public static void main(String[] args) throws IOException {
        @Cleanup InputStream in = new FileInputStream(args[0]);
        @Cleanup OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
    }
}
