package com.nio.chapter04.threadServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 15:57
 * @Version 1.0
 */
public class BeginClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是中国人".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
