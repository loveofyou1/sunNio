package com.java.base.reflect;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {
    private Map<String, Object> objectPool = new HashMap<>();

    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(clazzName);
        return clazz.newInstance();
    }


    public void initPool(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties properties = new Properties();
            properties.load(fis);
            for (String name : properties.stringPropertyNames()) {
                objectPool.put(name, createObject(properties.getProperty(name)));
            }
        } catch (Exception e) {
            System.out.println("读取" + fileName + "异常");
        }
    }

    public Object getObject(String name) {
        return objectPool.get(name);
    }

    public static void main(String[] args) {
        ObjectPoolFactory objectPoolFactory = new ObjectPoolFactory();
        objectPoolFactory.initPool("obj.txt");
        System.out.println(objectPoolFactory.getObject("a"));
        System.out.println(objectPoolFactory.getObject("b"));
        
    }
}
