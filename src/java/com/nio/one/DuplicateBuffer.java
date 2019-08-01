package com.nio.one;

import java.nio.CharBuffer;

/**
 * @author sunlei19
 * @create 2019/7/30
 */
public class DuplicateBuffer {

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(8);
        charBuffer.position(3).limit(6).mark().position(5);
        duplicate(charBuffer);
        slice();
    }

    private static void duplicate(CharBuffer charBuffer) {
        CharBuffer buff = charBuffer.duplicate();
        /*System.out.println(buff.array());
        System.out.println(buff.position());
        System.out.println(buff.mark());
        System.out.println(buff.limit());*/
    }

    private static void slice() {
        CharBuffer mainBuffer = CharBuffer.allocate(8);
        mainBuffer.position(3).limit(5);
        CharBuffer sliceBuffer = mainBuffer.slice();
        System.out.println(sliceBuffer.position());
        System.out.println(sliceBuffer.limit());
    }
}

