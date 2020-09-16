package com.nio.chapter05;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest3_1 {

    public static void main(String[] args) {
        // 阻塞 ip不存在
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            System.out.println("是否连接状态:" + socketChannel.isConnectionPending());
            // ip地址不存在 192.1.1.1
            socketChannel.connect(new InetSocketAddress("192.1.1.1", 8088));
            System.out.println("当前连接状态:"+socketChannel.isConnectionPending());
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch exception " + socketChannel.isConnectionPending());
        }

    }
}
