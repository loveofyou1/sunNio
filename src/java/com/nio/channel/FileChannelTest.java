package com.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("data/data.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(byteBuffer);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
    }


    private static void read() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(58);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] byteBufferArray = {header, body};

        RandomAccessFile file = new RandomAccessFile("hello.text", "rw");
        FileChannel fileChannel = file.getChannel();
        fileChannel.read(byteBufferArray);
    }

    private static void transferFrom() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("from.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("from.txt", "rw");
        FileChannel toChannel = fromFile.getChannel();

        long position = 0;
        long size = toChannel.size();
        toChannel.transferFrom(fromChannel, position, size);

    }

    private static void transferTo() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("from.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("from.txt", "rw");
        FileChannel toChannel = fromFile.getChannel();

        long position = 0;
        long size = toChannel.size();
        fromChannel.transferFrom(toChannel, position, size);

    }


}
