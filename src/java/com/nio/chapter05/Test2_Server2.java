package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test2_Server2 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        /**
         * 必须设置成false，否则会出现阻塞异常
         */
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost", 8888));
        // 核心代码开始
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 核心代码结束
        System.out.println("selector= " + selector);
        System.out.println("key=" + selectionKey);
        serverSocket.close();
        serverSocketChannel.close();
    }
}
