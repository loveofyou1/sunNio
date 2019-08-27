package com.java.base.proxy;

public class SimpleProxy {

    private Product product;

    public SimpleProxy(Product product) {
        this.product = product;
    }

    public void print(String msg) {
        this.product.play(msg);
    }
}
