package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description Test22
 * @Author sunlei19
 * @Date 2020/11/6 16:49
 * @Version 1.0
 */
public class Test22 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        boolean isRun = true;
        while (isRun) {

            System.out.println("while(isRun == true) " + System.currentTimeMillis());

            int keyCount = selector.select(5000);
            Set<SelectionKey> selectionKeysSet = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeysSet.iterator();
            while (iterator.hasNext()) {
                System.out.println("进入while");
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
                    Socket socket = serverSocketChannel1.socket().accept();
                    socket.close();
                }
                iterator.remove();
            }
        }
        serverSocketChannel.close();
    }
}
