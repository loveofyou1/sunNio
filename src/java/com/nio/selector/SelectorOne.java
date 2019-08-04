package com.nio.selector;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorOne {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);

        int interestOps = selectionKey.interestOps();
        int i = selectionKey.readyOps();
        boolean acceptable = selectionKey.isAcceptable();
        boolean connectable = selectionKey.isConnectable();
        boolean readable = selectionKey.isReadable();
        boolean writable = selectionKey.isWritable();

        SelectableChannel channel = selectionKey.channel();
        Selector selector1 = selectionKey.selector();

        int select = selector1.select();
        if (select > 0) {
            Set<SelectionKey> selectionKeys = selector1.selectedKeys();
            Iterator keyItorator = selectionKeys.iterator();
            while (keyItorator.hasNext()) {
                SelectionKey key = (SelectionKey) keyItorator.next();
                if (key.isAcceptable()) {

                } else if (key.isConnectable()) {

                }
                keyItorator.remove();
            }
        }
    }
}
