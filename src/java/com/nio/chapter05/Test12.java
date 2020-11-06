package com.nio.chapter05;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description Test12
 * @Author sunlei19
 * @Date 2020/11/6 14:15
 * @Version 1.0
 */
public class Test12 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        SelectionKey selectionKey1 = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        boolean isRun = true;

        while (true) {
            int keyCount = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    ServerSocket serverSocket = channel.socket();
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();

                    byte[] bytes = new byte[1024];
                    int readLength = inputStream.read(bytes);
                    while (readLength != -1) {
                        String newString = new String(bytes, 0, readLength);
                        System.out.println(newString);
                        readLength = inputStream.read(bytes);
                    }

                    inputStream.close();
                    socket.close();
                    iterator.remove();
                }
            }
            serverSocketChannel.close();
        }
    }
}
