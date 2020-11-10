package com.nio.chapter05.part9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test1_2 {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("localhost", 8888));
        boolean isRun = true;
        while (isRun) {
            int select = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isConnectable()) {
                    System.out.println("key isConnectable");
                    // 此处需要finishConnect完成连接，因为SocketChannel是非阻塞模式
                    while (!socketChannel.finishConnect()) {
                        System.out.println("!socketChannel.finishConnect();");
                    }

                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.close();
                }
                iterator.remove();
            }
        }
        socketChannel.close();
        System.out.println("end");
    }
}
