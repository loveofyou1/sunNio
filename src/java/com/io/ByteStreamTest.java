package com.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ByteStreamTest {
    public static void main(String[] args) {
        try {
            File file = new File("fileName");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            while (fileInputStream.read() > -1) {
                fileInputStream.read(bytes);
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
