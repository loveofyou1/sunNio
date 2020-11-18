package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description Test3
 * @Author sunlei19
 * @Date 2020/11/18 10:25
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        Future<FileLock> future = channel.lock(0, 3, false);
        FileLock lock = future.get();
        System.out.println("A  get lock time=" + System.currentTimeMillis());
        Thread.sleep(8000);
        lock.release();
        System.out.println("A release lock time=" + System.currentTimeMillis());
        channel.close();
    }
}
