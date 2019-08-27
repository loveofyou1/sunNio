package com.java.base.proxy;

import java.util.Arrays;

public class CellPhone implements Product {
    public void play(String message) {
        System.out.println(this.getClass().getName() + "===========" + message);
        System.out.println(Arrays.asList(this.getClass().getDeclaredMethods()));
        System.out.println(this.getClass().getDeclaringClass());
    }
}
