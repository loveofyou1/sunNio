package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description Test301
 * @Author sunlei19
 * @Date 2020/11/6 15:05
 * @Version 1.0
 */
public class Test301 {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 7777));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        boolean isRun = true;
        while (isRun) {
            int keyCount = selector.select();
            Set<SelectionKey> selectionKeySet = selector.keys();
            Set<SelectionKey> selectionKeySet1 = selector.selectedKeys();
            System.out.println("keyCount=" + keyCount);
            System.out.println("selectionKeySet size=" + selectionKeySet.size());
            System.out.println("selectionKeySet1 size=" + selectionKeySet1.size());

            System.out.println();
            Iterator<SelectionKey> iterator = selectionKeySet1.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel1.accept();
                socketChannel.configureBlocking(false);
                SelectionKey key1 = socketChannel.register(selector, SelectionKey.OP_READ);
                System.out.println("key1.isReadable() =" + ((SelectionKey.OP_READ & key1.interestOps()) == 0));
                System.out.println("key1.isWrite()=" + ((SelectionKey.OP_WRITE & key1.interestOps()) == 0));

                SelectionKey key2 = socketChannel.register(selector, SelectionKey.OP_READ & SelectionKey.OP_WRITE);
                System.out.println("key2.isRead=" + ((SelectionKey.OP_READ & SelectionKey.OP_WRITE) == 0));
                System.out.println("key2.isWrite=" + ((SelectionKey.OP_WRITE & key2.interestOps()) == 0));
                System.out.println("keyCountB=" + keyCount);
                System.out.println("set1 size = " + selectionKeySet.size());
                System.out.println("set2 size = " + selectionKeySet1.size());

            }
            Thread.sleep(Integer.MAX_VALUE);
        }

        serverSocketChannel.close();
    }
}
