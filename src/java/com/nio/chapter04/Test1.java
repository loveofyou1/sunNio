package com.nio.chapter04;

import java.io.IOException;
import java.net.Socket;

public class Test1 {

    public static void main(String[] args) throws IOException {
        Socket socket = null;

        try {

            //socket = new Socket("www.csdn.net", 80);
            socket = new Socket("www.csdn1.net", 80);
            System.out.println("socket连接状态" + socket.isConnected());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("socket 连接失败");
        } finally {
            socket.close();
        }
    }
}
