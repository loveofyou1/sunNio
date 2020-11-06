package com.nio.chapter05;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description Test13
 * @Author sunlei19
 * @Date 2020/11/6 14:27
 * @Version 1.0
 */
public class Test13 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是中国人，我来自客户端！".getBytes());
        socket.close();
    }
}
