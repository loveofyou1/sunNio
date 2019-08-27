package com.java.base.reflect;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) {
        try {
            Person p = new Person();
            Class<Person> clazz = Person.class;
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(p, "oracle");

            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(p, 20);
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
