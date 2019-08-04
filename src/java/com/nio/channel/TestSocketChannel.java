package com.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * SocketChannel建立连接，读写数据到缓冲区
 */
public class TestSocketChannel {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://www.baidu.com", 80));

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bufferSize = socketChannel.read(byteBuffer);

            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }

            write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void write() throws IOException {
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.clear();
        byteBuffer.put(newData.getBytes());
        byteBuffer.flip();

        SocketChannel socketChannel = SocketChannel.open();
        //未绑定服务器
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
        if (socketChannel.finishConnect()) {
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
                socketChannel.write(byteBuffer);
            }
        }
    }

}
