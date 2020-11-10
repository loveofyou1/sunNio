package com.nio.chapter05.part9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test1_1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        boolean isRun = true;

        while (isRun) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();

                Socket socket = null;
                // 测试此键的通道是否准备好接受新的套接字
                if (key.isAcceptable()) {
                    socket = serverSocketChannel1.socket().accept();
                    System.out.println("server isAcceptable");
                }
                socket.close();
                iterator.remove();
            }
        }
        serverSocketChannel.close();
    }
}
