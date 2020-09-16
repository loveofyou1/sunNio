package com.nio.chapter05;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Test1_Client4 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是发送的数据Client".getBytes());
        outputStream.close();
        socket.close();
    }
}
