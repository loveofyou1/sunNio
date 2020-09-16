package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test9 {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);

        Selector selector1 = Selector.open();
        Selector selector2 = Selector.open();

        SelectionKey selectionKey = serverSocketChannel.register(selector1, SelectionKey.OP_ACCEPT);
        System.out.println(selectionKey);

        SelectionKey selectionKey1 = serverSocketChannel.register(selector2, SelectionKey.OP_ACCEPT);
        System.out.println(selectionKey1);


    }
}
