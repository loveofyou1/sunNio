package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest4_1 {

    public static void main(String[] args) throws IOException {
        long beginTime = 0;
        long endTime = 0;

        SocketChannel socketChannel = SocketChannel.open();
        // 非阻塞模式
        socketChannel.configureBlocking(false);

        boolean connectResult = socketChannel.connect(new InetSocketAddress("localhost", 8088));
        if (!connectResult) {
            System.out.println("connectResult== false");
            while (!socketChannel.finishConnect()) {
                System.out.println("一直在尝试连接");
            }
        }
        socketChannel.close();
    }
}
