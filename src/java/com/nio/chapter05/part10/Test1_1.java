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
 * @Description Test1_1
 * @Author sunlei19
 * @Date 2020/11/10 21:12
 * @Version 1.0
 */
public class Test1_1 {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.configureBlocking(false);

        //如果两台物理计算机进行试验，则要把localhost改成服务端的IP地址
        channel.bind(new InetSocketAddress("localhost", 8888));

        Selector selector = Selector.open();
        SelectionKey selectionKey1 = channel.register(selector, SelectionKey.OP_READ);

        boolean isRun = true;
        while (isRun) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isReadable()) {
                    channel = (DatagramChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1000);
                    channel.receive(buffer);
                    System.out.println(new String(buffer.array(), 0, buffer.position()));
                }
                iterator.remove();
            }
        }

        channel.close();
    }
}
