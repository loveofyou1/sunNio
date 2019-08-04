package com.nio.channel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestServerSocketChannel {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9999));
            SocketChannel accept = serverSocketChannel.accept();

            ByteBuffer result = ByteBuffer.allocate(48);
            accept.read(result);
            result.flip();

            while (result.hasRemaining()) {
                System.out.println((char) result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
