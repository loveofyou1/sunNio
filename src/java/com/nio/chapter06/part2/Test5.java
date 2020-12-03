package com.nio.chapter06.part2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test5 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(8088));
        Future<AsynchronousSocketChannel> socketChannelFuture = serverSocketChannel.accept();
        AsynchronousSocketChannel socketChannel = socketChannelFuture.get();

        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        Future<Integer> future = socketChannel.read(byteBuffer);
        Future<Integer> future1 = socketChannel.read(byteBuffer);


    }
}
