package com.java.base.dynmic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    /**
     * 动态代理执行方法
     *
     * @param proxy  代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args   代理调用目标方法传入的实参
     * @return
     * @throws Throwable
     */
    public synchronized Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=====正在执行的方法" + method);
        if (args != null) {
            System.out.println("下面执行该方法时传入的实参：");
            for (Object obj : args) {
                System.out.println(obj);
            }
        } else {
            System.out.println("调用该方法没有实参。");
        }
        return null;
    }
}
