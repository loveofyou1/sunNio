package com.java.base.dynmic;

import com.java.base.proxy.Product;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynmicProxy {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        InvocationHandler invocationHandler = new MyInvocationHandler();

        Product cellPhone = (Product) Proxy.newProxyInstance(Product.class.getClassLoader(), new Class[]{Product.class}, invocationHandler);
        cellPhone.play("test Proxy");
    }
}
