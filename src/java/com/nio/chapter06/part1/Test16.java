package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description Test16
 * @Author sunlei19
 * @Date 2020/11/18 14:39
 * @Version 1.0
 */
public class Test16 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer byteBuffer = ByteBuffer.wrap("abcde".getBytes());

        channel.write(byteBuffer, 0, "我是附加的数据", new CompletionHandler<Integer, String>() {
            @Override
            public void completed(Integer result, String attachment) {
                System.out.println("public void completed(Integer result, String attachment) result = " + result + " attachment = " + attachment);
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                System.out.println("public void failed(Throwable exc, String attachment) attachment = " + attachment);
                System.out.println("getMessage = " + exc.getMessage());
            }
        });

        channel.close();
        Thread.sleep(2000);
    }
}
