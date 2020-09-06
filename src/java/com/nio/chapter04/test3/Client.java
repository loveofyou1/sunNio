package com.nio.chapter04.test3;

import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.println("socket begin " + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("socket end " + System.currentTimeMillis());
            Thread.sleep(3000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是外星人".getBytes());
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
