package com.nio.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test6 {
    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 8088));

        // 注册选择器
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        boolean isRun = true;
        while (isRun) {
            System.out.println("begin selector");

            if (socketChannel.isOpen()) {
                selector.select();
                System.out.println("end selector");

                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isConnectable()) {
                        while (!socketChannel.finishConnect()) {

                        }

                        socketChannel.register(selector, SelectionKey.OP_READ);

                    }

                    if (key.isReadable()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(50000);
                        int readLength = socketChannel.read(byteBuffer);
                        byteBuffer.flip();

                        int count = 0;
                        while (readLength != -1) {
                            count = count + readLength;
                            readLength = socketChannel.read(byteBuffer);
                            System.out.println("count =" + count + " readLength = " + readLength);
                            byteBuffer.clear();
                        }
                        System.out.println("读取结束");
                        socketChannel.close();
                    }
                }
            } else {
                break;
            }
        }
    }
}
