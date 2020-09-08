package com.nio.chapter04.test8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Description Server
 * @Author sunlei19
 * @Date 2020/9/8 20:45
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8888));
            System.out.println("server socket accept begin");
            serverSocket.accept();
            System.out.println("server accept end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
