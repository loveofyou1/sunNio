package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        long beginTime = 0;
        long endTime = 0;

        // SocketChannel 是阻塞模式
        // 在发生错误或连接到目标之前，connect方法一只是阻塞的
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        beginTime = System.currentTimeMillis();
        boolean connetResult = socketChannel.connect(new InetSocketAddress("localhost", 8088));
        endTime = System.currentTimeMillis();
        System.out.println("正常连接耗时：" + (endTime - beginTime) + " connetResult=" + connetResult);

        Thread.sleep(10000);
        socketChannel.close();
    }
}
