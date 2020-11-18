package com.nio.chapter05.part12;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;

/**
 * @Description Test1
 * @Author sunlei19
 * @Date 2020/11/10 22:30
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) throws IOException {

        SelectorProvider selectorProvider = SelectorProvider.provider();
        System.out.println("selectorProvider=" + selectorProvider.getClass().getName());

        Selector selector = selectorProvider.openSelector();
        DatagramChannel datagramChannel1 = selectorProvider.openDatagramChannel();
        DatagramChannel datagramChannel2 = selectorProvider.openDatagramChannel(StandardProtocolFamily.INET);
        DatagramChannel datagramChannel3 = selectorProvider.openDatagramChannel(StandardProtocolFamily.INET6);

        Pipe pipe = Pipe.open();
        ServerSocketChannel serverSocketChannel = selectorProvider.openServerSocketChannel();
        SocketChannel socketChannel = selectorProvider.openSocketChannel();

        // 源码返回null
        Channel channel = selectorProvider.inheritedChannel();
        System.out.println("openSelector()=" + selector.getClass().getName());
        System.out.println("openDatagramChannel()=" + datagramChannel1.getClass().getName());
        System.out.println("openDatagramChannel(StandardProtocolFamily.INET)=" + datagramChannel2.getClass().getName());
        System.out.println("openDatagramChannel(StandardProtocolFamily.INET6)=" + datagramChannel3.getClass().getName());
        System.out.println("openPipe()=" + pipe.getClass().getName());
        System.out.println("openServerSocketChannel()=" + serverSocketChannel.getClass().getName());
        System.out.println("openSocketChannel()=" + socketChannel.getClass().getName());
        System.out.println("inheritedChannel()=" + channel);
    }
}
