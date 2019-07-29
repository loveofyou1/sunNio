package com.nio.one;

import java.nio.ByteBuffer;

public class TestNio {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');
        buffer.put(0, (byte) 'M').put((byte) 'w');

        //wrap method
        //wrapMethod(buffer);

        //flip翻转缓冲区，limit到缓冲区最后的位置
        buffer.flip();

        //rewind(buffer);

        //remaining(buffer);

        compact(buffer);
    }

    private static void wrapMethod(ByteBuffer buffer) {
        byte[] arr = buffer.array();
        ByteBuffer arrayBuffer = ByteBuffer.wrap(arr, 0, 1);
        for (byte arry : arrayBuffer.array()) {
            char chr = (char) arry;
        }
    }

    private static void rewind(ByteBuffer buffer) {
        buffer.rewind();//limit还是初始长度
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
    }

    private static void remaining(ByteBuffer buffer) {
        byte[] myByteArray = new byte[buffer.limit()];
        for (int i = 0; buffer.hasRemaining(); i++) {
            myByteArray[i] = buffer.get();
        }
    }

    private static void compact(ByteBuffer buffer) {
        //首先释放两个元素
        System.out.println(buffer.get());
        System.out.println(buffer.get());
        //压缩缓冲区，将未释放的数据前移
        buffer.compact();
        //翻转缓冲区，将position设置到0
        buffer.flip();
        for (int i = 0; buffer.hasRemaining(); i++) {
            System.out.print(buffer.get() + " ");
        }
    }
}
