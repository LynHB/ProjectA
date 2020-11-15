package study.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/*
    实现HttpHandle处理Http请求
 */
public class HttpServerDemo implements HttpHandler {
    public static void main(String[] args) throws IOException {
        // 绑定本地指定8888
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getByName("0.0.0.0"),8888),511);
        // 设置上下文信息
        httpServer.createContext("/",new HttpServerDemo());
        // 启动服务
        httpServer.start();


    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = httpExchange.getRequestURI()+":test message";
        httpExchange.sendResponseHeaders(200, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes(StandardCharsets.UTF_8));
        os.close();
    }
}
