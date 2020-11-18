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
 * @Description Test15
 * @Author sunlei19
 * @Date 2020/11/18 14:36
 * @Version 1.0
 */
public class Test15 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.wrap("12345".getBytes());
        Future<Integer> future = channel.write(buffer, channel.size());
        System.out.println("length = " + future.get());
        channel.close();
    }
}
