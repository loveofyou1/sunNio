package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test7 {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("selectKey1=" + selectionKey1 + " selectkey1 hashCode=" + selectionKey1.hashCode());

        SelectionKey selectionKey2 = serverSocketChannel.keyFor(selector);
        System.out.println("selectKey2=" + selectionKey2+" selectkey2 hashCode=" + selectionKey2.hashCode());

        serverSocketChannel.close();

    }
}
