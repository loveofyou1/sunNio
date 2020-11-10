package com.nio.chapter05.part10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description Test1_2
 * @Author sunlei19
 * @Date 2020/11/10 21:19
 * @Version 1.0
 */
public class Test1_2 {
    public static void main(String[] args) throws IOException {

        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_WRITE);

        int keyCount = selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            if (next.isWritable()) {
                ByteBuffer buffer = ByteBuffer.wrap("我来自客户端！".getBytes());
                //如果是两台物理计算机中进行试验，则要把localhost改成客户端的IP地址
                channel.send(buffer, new InetSocketAddress("localhost", 8888));
                channel.close();
            }
        }
        System.out.println("client end!");
    }
}
