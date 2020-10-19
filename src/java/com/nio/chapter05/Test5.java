package com.nio.chapter05;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Test5 {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8088));


        SocketChannel socketChannel = null;

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        boolean isRun = true;
        while (isRun) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                // 已经建立连接
                if (key.isAcceptable()) {
                    socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }

                // 通道准备好写入文件
                if (key.isWritable()) {
                    RandomAccessFile accessFile = new RandomAccessFile("/Users/sunlei19/Downloads/elmediaplayer.dmg", "rw");
                    System.out.println("文件大小=" + accessFile.length());
                    FileChannel fileChannel = accessFile.getChannel();
                    fileChannel.transferTo(0, accessFile.length(), socketChannel);
                    fileChannel.close();
                    accessFile.close();
                    socketChannel.close();
                }
            }

        }

        serverSocketChannel.close();
    }
}
