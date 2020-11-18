package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description Test9
 * @Author sunlei19
 * @Date 2020/11/18 10:49
 * @Version 1.0
 */
public class Test9 {

    private static AsynchronousFileChannel channel;

    public static void main(String[] args) throws IOException, InterruptedException {

        Path path = Paths.get("D:\\a.txt");
        channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.READ);
        channel.close();

        channel.lock("我是字符串我是附件", new CompletionHandler<FileLock, String>() {
            @Override
            public void completed(FileLock result, String attachment) {
                try {
                    result.release();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                //exc.printStackTrace();
                System.out.println("public void failed(Throwable exc, String attachment) ，attachment = " + attachment);
                System.out.println("attachment = " + attachment + " getMessage=" + exc.getMessage());
                System.out.println("exc.getClass().getName" + exc.getClass().getName());
            }
        });

        Thread.sleep(3000);
    }
}
