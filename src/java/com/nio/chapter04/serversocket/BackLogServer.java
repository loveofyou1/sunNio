package com.nio.chapter04.serversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description BackLogServer
 * @Author sunlei19
 * @Date 2020/9/8 20:20
 * @Version 1.0
 */
public class BackLogServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088, 4);
            /** sleep(5000)睡眠5s的作用不让ServerSocket调用accept
             *  而是由客户端Socket先发起10个连接请求
             *  然后再执行accept方法时只能接受3个连接
             * */
            Thread.sleep(5000);
            System.out.println("accept1 begin");
            Socket socket1 = serverSocket.accept();
            System.out.println("accept1 end");
            System.out.println("accept2 begin");
            Socket socket2 = serverSocket.accept();
            System.out.println("accept2 end");
            System.out.println("accept3 begin");
            Socket socket3 = serverSocket.accept();
            System.out.println("accept3 end");
            System.out.println("accept4 begin");
            Socket socket4 = serverSocket.accept();
            System.out.println("accept4 end");
            System.out.println("accept5 begin");
            Socket socket5 = serverSocket.accept();
            System.out.println("accept5 end");

            socket1.close();
            socket2.close();
            socket3.close();
            socket4.close();
            socket5.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
