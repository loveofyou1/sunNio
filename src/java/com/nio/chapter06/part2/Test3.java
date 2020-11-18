package com.nio.chapter06.part2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description Test3
 * @Author sunlei19
 * @Date 2020/11/18 17:58
 * @Version 1.0
 */
public class Test3 {

    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8888), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                try {
                    Future<Integer> future = socketChannel.write(ByteBuffer.wrap("我来自客户端2".getBytes()));
                    System.out.println("写入大小：" + future.get());
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {

            }
        });
        Thread.sleep(1000);
    }
}
