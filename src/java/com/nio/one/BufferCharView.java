package com.nio.one;

import java.nio.*;

/**
 * test asCharBuffer view
 */
public class BufferCharView {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = buffer.asCharBuffer();
        //load the ByteBuffer with some bytes
        buffer.put(0, (byte) 0);
        buffer.put(1, (byte) 'H');
        buffer.put(2, (byte) 0);
        buffer.put(3, (byte) 'i');
        buffer.put(4, (byte) 0);
        buffer.put(5, (byte) '!');
        buffer.put(6, (byte) 0);

        println(buffer);
        println(charBuffer);
        IntBuffer intBuffer = buffer.asIntBuffer();
        println(intBuffer);
        System.out.println(buffer.getInt());
    }

    private static void println(Buffer buffer) {
        System.out.println("pos=" + buffer.position() + ",limit=" +
                buffer.limit() + ",capacity=" + buffer.capacity() +
                ",'" + buffer.toString() + "'");
    }
}
