package com.nio.chapter04.serversocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * @Description AddressServer
 * @Author sunlei19
 * @Date 2020/9/8 20:32
 * @Version 1.0
 */
public class AddressServer {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ServerSocket serverSocket = new ServerSocket(8088, 0, inetAddress);
            Thread.sleep(5000);
            for (int i = 0; i < 100; i++) {
                System.out.println("accept" + i + " begin");
                serverSocket.accept();
                System.out.println("accept" + i + " end");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
