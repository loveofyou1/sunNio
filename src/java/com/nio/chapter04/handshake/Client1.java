package com.nio.chapter04.handshake;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Description Client1
 * @Author sunlei19
 * @Date 2020/9/8 15:25
 * @Version 1.0
 */
public class Client1 {
    public static void main(String[] args) {
        try {
            System.out.println("client准备连接开始=" + System.currentTimeMillis());
            Socket socket = new Socket("localhost", 8088);
            System.out.println("client连接结束=" + System.currentTimeMillis());

            socket.close();
            Thread.sleep(2000);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
