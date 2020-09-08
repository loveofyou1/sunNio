package com.nio.chapter04.socketTest3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 21:48
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // bind绑定本地端口号7777，connect连接的服务端端口号8888
        socket.bind(new InetSocketAddress("localhost", 7777));
        socket.connect(new InetSocketAddress("localhost", 8888));
        System.out.println("client output");
        System.out.println("client port = " + socket.getLocalPort());
        System.out.println("server port = " + socket.getPort());
        socket.close();
    }
}
