package com.nio.one;

import java.nio.CharBuffer;

/**
 * 填充和释放缓冲区
 */
public class BufferFillDrain {
    private static int index = 0;

    private static String[] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees:Jimi Hendrix",
            "'Scure me while I kiss this fly",
            "Help me! Help me!"};

    public static void main(String[] args) {
        //给缓冲区分配空间
        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println(" ");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return false;
        }

        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }

}
