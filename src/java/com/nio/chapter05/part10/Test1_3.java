package com.nio.chapter05.part10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @Description Test1_3
 * @Author sunlei19
 * @Date 2020/11/10 21:34
 * @Version 1.0
 */
public class Test1_3 {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);

        // 如果是两台物理计算机中进行试验，则要把localhost改成服务端的IP地址
        channel.connect(new InetSocketAddress("localhost", 8888));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_WRITE);
        int keyCount = selector.select();
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

        while (iterator.hasNext()) {
            SelectionKey key = iterator.next();
            if (key.isWritable()) {
                ByteBuffer buffer = ByteBuffer.wrap("我来自客户端的数据！".getBytes());
                channel.write(buffer);
                channel.close();
            }
        }
        System.out.println("client end!");
    }
}
