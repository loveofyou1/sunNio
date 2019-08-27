package com.java.base.reflect;

import com.netty.simple.DiscardServer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class OneReflect {
    public static void main(String[] args) {
        try {
            Class<?> clazz = DiscardServer.class;
            Constructor[] constructors = clazz.getConstructors();
            System.out.println(Arrays.asList(constructors));

            Annotation[] annotations = clazz.getAnnotations();
            System.out.println(Arrays.asList(annotations));

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println(Arrays.asList(methods));

            Method[] methods1 = clazz.getMethods();
            System.out.println(Arrays.asList(methods1));

            Field[] fields = clazz.getDeclaredFields();
            System.out.println(Arrays.asList(fields));

            Field[] pubFields = clazz.getFields();
            System.out.println(Arrays.asList(pubFields));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
