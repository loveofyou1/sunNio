package com.nio.chapter05;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test7_1 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8088);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int readLength = inputStream.read(bytes);
        while (readLength != -1) {
            System.out.println(new String(bytes, 0, readLength));
            readLength = inputStream.read(bytes);
        }

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
