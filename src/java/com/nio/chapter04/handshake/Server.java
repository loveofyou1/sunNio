package com.nio.chapter04.handshake;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Description Server
 * @Author sunlei19
 * @Date 2020/9/8 10:31
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server阻塞开始=" + System.currentTimeMillis());
            serverSocket.accept();
            System.out.println("server阻塞结束=" + System.currentTimeMillis());
            Thread.sleep(Integer.MAX_VALUE);
            serverSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
