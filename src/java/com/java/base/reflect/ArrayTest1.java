package com.java.base.reflect;

import java.lang.reflect.Array;

public class ArrayTest1 {
    public static void main(String[] args) {
        Object arr = Array.newInstance(String.class, 10);
        Array.set(arr, 5, "疯狂java讲义");
        Array.set(arr, 6, "轻量级java ee企业应用实战");

        Object book1 = Array.get(arr, 5);
        Object book2 = Array.get(arr, 6);

        System.out.println(book1);
        System.out.println(book2);

    }
}
