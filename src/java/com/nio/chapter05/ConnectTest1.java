package com.nio.chapter05;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest1 {
    public static void main(String[] args) {
        long beginTime = 0;
        long endTime = 0;
        boolean connetResult = false;
        try {
            // SocketChannel 是阻塞模式
            // 在发生错误或连接到目标之前，connect方法一只是阻塞的
            SocketChannel socketChannel = SocketChannel.open();
            beginTime = System.currentTimeMillis();
            connetResult = socketChannel.connect(new InetSocketAddress("localhost", 8088));
            endTime = System.currentTimeMillis();
            System.out.println("正常连接耗时：" + (endTime - beginTime) + " connetResult=" + connetResult);

            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
            endTime = System.currentTimeMillis();
            System.out.println("异常连接耗时：" + (endTime - beginTime) + " connetResult=" + connetResult);
        }
    }
}
