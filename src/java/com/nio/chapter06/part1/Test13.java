package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description Test13
 * @Author sunlei19
 * @Date 2020/11/18 14:26
 * @Version 1.0
 */
public class Test13 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(5);
        Future<Integer> future = channel.read(buffer, 0);
        System.out.println("length = " + future.get());
        channel.close();

        System.out.println(new String(buffer.array()));
    }
}
