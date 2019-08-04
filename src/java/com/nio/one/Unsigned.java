package com.nio.one;

import java.nio.ByteBuffer;

/**
 * 向ByteBuffer对象中获取和存放无符号值的工具类。
 * 这里所有的函数都是静态的，并且带有一个Bytebuffer参数。
 * 由于java不提供无符号原始类型，每个从缓冲区中读出的无符号值被提升到比它大的
 * 下一个基本数据类型中。
 * getUnsignedByte()返回一个short类型，getUnsignedShort()
 * 返回一个int类型，而getUnsignedInt()返回一个long型。
 * 由于没有基本类型类存储返回的数据，因此没有getUnsigedLong().
 * 如果需要，返回BigInteger的函数可以执行。
 * 同样，存放函数要取一个大于它们所分配的类型的值。
 * putUnsignedByte取一个short型参数，等等。
 */
public class Unsigned {
    public static short getUnsignedByte(ByteBuffer byteBuffer) {
        return ((short) (byteBuffer.get() & 0xff));
    }

    public static void putUnsignedByte(ByteBuffer byteBuffer, int value) {
        byteBuffer.put((byte) (value & 0xff));
    }

    public static short getUnsignedByte(ByteBuffer byteBuffer, int position) {
        return ((short) (byteBuffer.get(position) & (short) 0xff));
    }

    public static void putUnsignedByte(ByteBuffer byteBuffer, int position, int value) {
        byteBuffer.put(position, (byte) (value & 0xff));
    }


    public static int getUnsignedShort(ByteBuffer byteBuffer) {
        return (byteBuffer.getShort() & 0xffff);
    }

    public static void putUnsignedShort(ByteBuffer byteBuffer, int value) {
        byteBuffer.putShort((short) (value & 0xffff));
    }

    public static int getUnsignedShort(ByteBuffer byteBuffer, int position) {
        return (byteBuffer.getShort(position) & 0xffff);
    }

    public static void putUnsignedShort(ByteBuffer byteBuffer, int position, int value) {
        byteBuffer.putShort(position, (short) (value & 0xffff));
    }

    public static long getUnsignedInt(ByteBuffer byteBuffer) {
        return ((long) (byteBuffer.getInt() & 0xffffffffL));
    }

    public static void putUnsignedInt(ByteBuffer byteBuffer, long value) {
        byteBuffer.putInt((int) (value & 0xffffffffL));
    }

    public static long getUnsignedInt(ByteBuffer byteBuffer, int position) {
        return ((long) byteBuffer.getInt(position) & 0xffffffffL);
    }

    public static void putUnsignedInt(ByteBuffer byteBuffer, int position, long value) {
        byteBuffer.putInt(position, (int) (value & 0xffffffffL));
    }
}
