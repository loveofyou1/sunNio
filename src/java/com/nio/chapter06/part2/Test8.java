package com.nio.chapter06.part2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

public class Test8 {
    public static void main(String[] args) throws IOException, InterruptedException {
        final AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8088), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1000);
                    for (int i = 0; i < 1000-3; i++) {
                        byteBuffer.put("1".getBytes());
                    }

                    byteBuffer.put("end".getBytes());
                    byteBuffer.flip();

                    int writeSum = 0;
                    // 由于write()方法时异步的，所以执行write（）方法后
                    // 并不能100%将数据写出，所以通过writeLength变量
                    // 来判断具体写出多少字节的数据
                    while (writeSum < byteBuffer.limit()) {
                        Future<Integer> writeFuture = socketChannel.write(byteBuffer);
                        Integer writeLength = writeFuture.get();
                        writeSum = writeSum + writeLength;
                    }
                    socketChannel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("connect public void failed(Throwable exc, Void attachment) ");
                System.out.println("exc getMeesage() =" + exc.getClass().getName());
            }
        });
        Thread.sleep(1000);
    }
}
