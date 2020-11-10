package com.nio.chapter05.part9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test2_2 {

    public static void main(String[] args) throws IOException {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost", 8888));

            int keyCount = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isConnectable()) {
                    while (!socketChannel.finishConnect()) {
                        System.out.println("!socketChannel.finishConnect()");
                    }

                    System.out.println("client isConnectable");
                    SocketChannel channel = (SocketChannel) key.channel();
                    byte[] writeDate = "我来自客户端，你好，服务端".getBytes();
                    ByteBuffer byteBuffer = ByteBuffer.wrap(writeDate);
                    channel.write(byteBuffer);
                    channel.close();

                }
            }
            System.out.println("client end");

        } catch (ClosedChannelException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
