package com.nio.chapter04.test8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Description BackLogServer
 * @Author sunlei19
 * @Date 2020/9/8 20:48
 * @Version 1.0
 */
public class BackLogServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8888), Integer.MAX_VALUE);
            Thread.sleep(20000);
            serverSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
