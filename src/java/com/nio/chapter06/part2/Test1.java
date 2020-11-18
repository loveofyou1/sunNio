package com.nio.chapter06.part2;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description Test1
 * @Author sunlei19
 * @Date 2020/11/18 16:01
 * @Version 1.0
 */
public class Test1 {

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                try {
                    serverSocketChannel.accept(null, this);
                    System.out.println("public void completed(AsynchronousSocketChannel result, Void attachment) threadName=" + Thread.currentThread().getName());
                    ByteBuffer byteBuffer = ByteBuffer.allocate(20);
                    Future<Integer> future = result.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array(), 0, future.get()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("public void failed(Throwable exc, Void attachment) attachment = " + attachment);
                System.out.println("getMessage = " + exc.getMessage());
            }
        });
        while (true) {

        }
    }
}
