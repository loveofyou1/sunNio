package com.nio.chapter06.part2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @Description Test
 * @Author sunlei19
 * @Date 2020/11/18 15:58
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {

        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                serverSocketChannel.accept(null, this);
                //handle
            }

            @Override
            public void failed(Throwable exc, Void attachment) {

            }
        });
    }
}
