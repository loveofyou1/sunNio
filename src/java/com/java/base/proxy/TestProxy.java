package com.java.base.proxy;

public class TestProxy {
    public static void main(String[] args) {
        Product cellphone = new CellPhone();
        SimpleProxy simpleProxy = new SimpleProxy(cellphone);
        simpleProxy.print("hello");

        try {
            Class<?> hello = Class.forName("com.java.base.proxy.Pad");
            System.out.println(hello.getSuperclass());;
            Pad pad = (Pad) hello.newInstance();
            pad.play("nihao");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
