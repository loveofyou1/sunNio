package com.java.base.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public class MethdoParameterTest {
    public static void main(String[] args) {
        Class<?> clazz = Test.class;

        try {
            Method replace = clazz.getMethod("repplace", String.class, List.class);
            System.out.println("replace参数个数:" + replace.getParameterCount());

            Parameter[] parameters = replace.getParameters();
            int index = 1;
            for (Parameter parameter : parameters) {
                if (parameter.isNamePresent()) {
                    index++;
                    System.out.println("index:" + index);
                    System.out.println("参数名："+parameter.getName());
                    System.out.println("形参类型："+parameter.getType());
                    System.out.println("范型类型："+parameter.getParameterizedType());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test {
    public void repplace(String str, List<String> list) {

    }
}
