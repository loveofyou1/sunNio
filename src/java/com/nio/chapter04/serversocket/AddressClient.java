package com.nio.chapter04.serversocket;

import java.net.InetAddress;
import java.net.Socket;

/**
 * @Description AddressClient
 * @Author sunlei19
 * @Date 2020/9/8 20:34
 * @Version 1.0
 */
public class AddressClient {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            for (int i = 0; i < 100; i++) {
                Socket socket = new Socket(inetAddress, 8088);
                System.out.println("client connect count = " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
