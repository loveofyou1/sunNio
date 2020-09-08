package com.nio.chapter04.test8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @Description SocketAddressServer
 * @Author sunlei19
 * @Date 2020/9/8 20:53
 * @Version 1.0
 */
public class SocketAddressServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("10.1.68.27", 8888));
        System.out.println("bind port = " + serverSocket.getLocalPort());
        InetSocketAddress inetSocketAddress = (InetSocketAddress) serverSocket.getLocalSocketAddress();
        System.out.println("InetSocketAddress.getHostName =" + inetSocketAddress.getHostName());
        System.out.println("InetSocketAddress.getHostString=" + inetSocketAddress.getHostString());
        System.out.println("InetSocketAddress.getPort=" + inetSocketAddress.getPort());
    }
}
