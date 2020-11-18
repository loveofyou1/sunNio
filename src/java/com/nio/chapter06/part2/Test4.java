package com.nio.chapter06.part2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description Test4
 * @Author sunlei19
 * @Date 2020/11/18 18:07
 * @Version 1.0
 */
public class Test4 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        System.out.println("A time =" + System.currentTimeMillis());
        Future<AsynchronousSocketChannel> socketChannelFuture = serverSocketChannel.accept();
        System.out.println("B time = " + System.currentTimeMillis());
        AsynchronousSocketChannel asynchronousSocketChannel = socketChannelFuture.get();
        System.out.println("C time = " + System.currentTimeMillis());
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        System.out.println("D time = " + System.currentTimeMillis());
        Future<Integer> future = asynchronousSocketChannel.read(byteBuffer);
        System.out.println("E time = " + System.currentTimeMillis());
        System.out.println(new String(byteBuffer.array(), 0, future.get()));
        System.out.println("F time = " + System.currentTimeMillis());
        Thread.sleep(40000);
    }
}
