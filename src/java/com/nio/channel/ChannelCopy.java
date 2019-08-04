package com.nio.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Test copying between channels
 */
public class ChannelCopy {

    /**
     * 复制数据从入口到出口
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        ReadableByteChannel source = Channels.newChannel(System.in);
        WritableByteChannel dest = Channels.newChannel(System.out);
        channelCopy1(source, dest);
        source.close();
        dest.close();
    }

    private static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(buffer) != -1) {
            //prepare the buffer to be drained
            buffer.flip();
            //write to the channel;may block
            dest.write(buffer);
            //If partial transfer,shift remainder down
            //If buffer is empty,same as doing clear()
            buffer.compact();
        }
        //EOF will leave buffer in fill state
        buffer.flip();
        //Make sure that the buffer is fully drained
        while (buffer.hasRemaining()) {
            dest.write(buffer);
        }
    }


    private static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);
        buffer.flip();
        while (buffer.hasRemaining()) {
            dest.write(buffer);
        }
        buffer.clear();
    }
}
