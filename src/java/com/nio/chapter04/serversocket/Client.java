package com.nio.chapter04.serversocket;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 20:16
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client begin " + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("client end " + System.currentTimeMillis());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("catch " + System.currentTimeMillis());
        }
    }
}
