package com.nio.chapter04.handshake;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 10:34
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("连接开始=" + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("client连接结束=" + System.currentTimeMillis());

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("111".getBytes());
            outputStream.write("1111".getBytes());
            outputStream.write("111111".getBytes());
            Thread.sleep(5000000);
            outputStream.close();
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
