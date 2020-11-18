package com.nio.chapter05.part11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Description Test1_1
 * @Author sunlei19
 * @Date 2020/11/10 22:21
 * @Version 1.0
 */
public class Test1_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        Pipe.SourceChannel sourceChannel = pipe.source();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < 5; i++) {
                    sinkChannel.write(ByteBuffer.wrap(("我来自客户端A" + (i + 1) + "\r\n").getBytes()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < 5; i++) {
                    sinkChannel.write(ByteBuffer.wrap(("我来自客户端B" + (i + 1) + "\r\n").getBytes()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        Thread.sleep(3000);
        sinkChannel.close();

        ByteBuffer readBuffer = ByteBuffer.allocate(1000);
        int readLength = sourceChannel.read(readBuffer);
        while (readLength != -1) {
            System.out.println(new String(readBuffer.array(), 0, readLength));
            readLength = sourceChannel.read(readBuffer);
        }

        sourceChannel.close();
    }
}
