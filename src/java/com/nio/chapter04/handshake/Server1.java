package com.nio.chapter04.handshake;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description Server1
 * @Author sunlei19
 * @Date 2020/9/8 15:21
 * @Version 1.0
 */
public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("socket 阻塞开始=" + System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println("socket 阻塞结束=" + System.currentTimeMillis());

            socket.close();
            serverSocket.close();
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
