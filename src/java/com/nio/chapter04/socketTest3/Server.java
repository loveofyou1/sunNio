package com.nio.chapter04.socketTest3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description Server
 * @Author sunlei19
 * @Date 2020/9/8 21:46
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("server output ");
        System.out.println("server port =" + socket.getLocalPort());
        System.out.println("client port = " + socket.getPort());
        socket.close();
        serverSocket.close();
    }
}
