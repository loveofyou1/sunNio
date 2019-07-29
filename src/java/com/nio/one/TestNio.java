package com.nio.one;

import sun.jvm.hotspot.runtime.Bytes;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestNio {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
        buffer.put(0,(byte)'M').put((byte)'w');

        //wrap method
        byte[] arr = buffer.array();
        ByteBuffer arrayBuffer = ByteBuffer.wrap(arr,0,1);
    /*    for (byte arry : arrayBuffer.array()) {
            char chr = (char) arry;
            System.out.println(chr);
        }*/

        //flip翻转缓冲区，limit到缓冲区最后的位置
        //buffer.flip();

        buffer.rewind();//limit还是初始长度
        byte[] bytes = new byte[buffer.limit()];
        System.out.println(buffer.limit());
        //System.out.println((char)buffer.get());
        buffer.get(bytes);
        System.out.println(Arrays.toString(bytes));
    }
}
