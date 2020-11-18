package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description Test8_1
 * @Author sunlei19
 * @Date 2020/11/18 14:03
 * @Version 1.0
 */
public class Test8_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("A begin time = " + System.currentTimeMillis());
        channel.lock("我是附加值A", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    Thread.sleep(9000);
                    result.release();
                    System.out.println("A release lock time = " + System.currentTimeMillis());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("public void failed(Throwable exc, String attachment) attachment= " + attachment);
                System.out.println("getMessage = " + exc.getMessage());
            }
        });

        Thread.sleep(10000);
        channel.close();
    }
}
