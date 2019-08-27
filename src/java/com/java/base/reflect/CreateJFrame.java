package com.java.base.reflect;

import java.lang.reflect.Constructor;

public class CreateJFrame {
    public static void main(String[] args) {

        try {
            Class<?> clazz = Class.forName("javax.swing.JFrame");
            Constructor constructor = clazz.getConstructor(String.class);
            Object object = constructor.newInstance("测试窗口");
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
