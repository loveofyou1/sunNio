package com.nio.chapter05;

import java.io.IOException;
import java.nio.channels.Selector;

public class Test2 {
    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        System.out.println(selector);
    }
}
