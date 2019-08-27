package com.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Serializable {

    private static final long serialVersionUID = -9103176221415991486L;
    public int num = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("D:/serialize.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            Serialize serialize = new Serialize();
            objectOutputStream.writeObject(serialize);
            objectOutputStream.flush();
            objectOutputStream.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
