package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description Test8_2
 * @Author sunlei19
 * @Date 2020/11/18 14:06
 * @Version 1.0
 */
public class Test8_2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        System.out.println("B begin time = " + System.currentTimeMillis());

        channel.lock("我是附加值B", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    System.out.println("B public void completed(FileLock result, String attachment) attachment = " + attachment);
                    System.out.println("B get lock time = " + System.currentTimeMillis());
                    result.release();
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("B public void failed(Throwable exc, String attachment) attachment = " + attachment);
                System.out.println("getMessage = " + exc.getMessage());
            }
        });

        System.out.println("B end time = " + System.currentTimeMillis());
        Thread.sleep(50000);
    }
}
