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
 * @Description Test4
 * @Author sunlei19
 * @Date 2020/11/18 10:28
 * @Version 1.0
 */
public class Test4 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("B  lock begin =" + System.currentTimeMillis());
        Future<FileLock> future = channel.lock(0, 3, false);
        System.out.println("B  lock end =" + System.currentTimeMillis());
        FileLock lock = future.get();
        System.out.println("B  lock end time=" + System.currentTimeMillis());
        lock.release();
        channel.close();

    }
}
