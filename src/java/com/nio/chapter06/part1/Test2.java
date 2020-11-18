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
 * @Description Test2
 * @Author sunlei19
 * @Date 2020/11/18 10:18
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Path path = Paths.get("D:\\a.txt");

        AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        System.out.println("lock begin " + System.currentTimeMillis());
        Future<FileLock> fileLockFuture = asynchronousFileChannel.lock();
        System.out.println("lock end " + System.currentTimeMillis());

        FileLock lock = fileLockFuture.get();
        System.out.println("B get lock time=" + System.currentTimeMillis());
        lock.release();
        asynchronousFileChannel.close();
    }
}
