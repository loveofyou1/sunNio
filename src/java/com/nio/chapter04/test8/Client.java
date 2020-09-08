package com.nio.chapter04.test8;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 20:46
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client request begin");
            Socket socket = new Socket("localhost", 8888);
            System.out.println("client request end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
