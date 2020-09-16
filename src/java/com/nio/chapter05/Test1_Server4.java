package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Test1_Server4 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);

        int readLength = socketChannel.read(byteBuffer);
        while (readLength != -1) {
            String newString = new String(byteBuffer.array());
            System.out.println(newString);
            byteBuffer.flip();
            readLength = socketChannel.read(byteBuffer);
        }

        socketChannel.close();
        serverSocketChannel.close();

    }
}
