package com.nio.chapter05;

import java.io.IOException;
import java.net.Socket;

public class Test1_Client3 {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 200; i++) {
            Socket socket = new Socket("localhost", 8888);
            socket.close();
            System.out.println("客户端建立第" + i + "个连接");
        }
    }
}
