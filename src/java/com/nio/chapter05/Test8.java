package com.nio.chapter05;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class Test8 {

    /**
     * 不同写法获取相同的provider
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // 获取provider方法一
        SelectorProvider selectorProvider = SelectorProvider.provider();
        System.out.println(selectorProvider);

        ServerSocketChannel serverSocketChannel = null;
        serverSocketChannel = ServerSocketChannel.open();
        // 获取provider方法二
        SelectorProvider selectorProvider1 = serverSocketChannel.provider();
        System.out.println(selectorProvider1);
    }
}
