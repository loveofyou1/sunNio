package com.nio.chapter04.test4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * server 发送信息到客户端
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server阻塞开始=" + System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println("server阻塞结束=" + System.currentTimeMillis());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是孙磊，我来自服务端！".getBytes());
            outputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
