package com.nio.chapter04.serversocket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Description Server
 * @Author sunlei19
 * @Date 2020/9/8 20:12
 * @Version 1.0
 */
public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server socket blocking ");
            System.out.println("server socket timeout begin = " + serverSocket.getSoTimeout());
            serverSocket.setSoTimeout(4000);
            System.out.println("server socket timeout= " + serverSocket.getSoTimeout());
            System.out.println("server accept begin");
            serverSocket.accept();
            System.out.println("server accept end");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
