package study.netty.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Huang
 */
public class Netty01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        // 1.堵塞等待一个连接
        Socket clientSocket = serverSocket.accept();
        // 2.通过socket获得流数据
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
        String request, response;
        // 3.遇到Done跳出，否则处理数据，输出返回流中
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            response = processRequest(request);
            out.println(response);
        }
    }
    public static String processRequest(String request){
        return "Processed:"+request;
    }
}
