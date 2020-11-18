package com.nio.chapter06.part1;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description Test6
 * @Author sunlei19
 * @Date 2020/11/18 10:38
 * @Version 1.0
 */
public class Test6 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\a.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        System.out.println("File size=" + channel.size());
        System.out.println("A isOpen = " + channel.isOpen());
        channel.close();
        System.out.println("B isOpen = " + channel.isOpen());
    }
}
