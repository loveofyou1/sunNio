package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class Test1_Server3 {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888), 100);
        ServerSocket serverSocket = serverSocketChannel.socket();
        //serverSocket.bind(new InetSocketAddress("localhost", 8888), 20);

        Thread.sleep(5000);
        boolean isRun = true;
        int count = 0;
        while (isRun) {
            Socket socket = serverSocket.accept();
            count++;
            System.out.println("服务端接受的连接数:" + count);
            socket.close();
        }
        Thread.sleep(8000);
        serverSocket.close();
        serverSocketChannel.close();
    }
}
