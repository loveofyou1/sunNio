package com.nio.chapter05;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class Test1_Server1 {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 二：套接字通道绑定本地地址
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        ServerSocket serverSocket = serverSocketChannel.socket();
        // 一：套接字绑定本地地址
        //serverSocket.bind(new InetSocketAddress("localhost", 8888));
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] chars = new char[1024];
        int readLength = inputStreamReader.read(chars);
        while (readLength != -1) {
            String newString = new String(chars, 0, readLength);
            System.out.println(newString);
            readLength = inputStreamReader.read(chars);
        }

        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        serverSocketChannel.close();
    }
}
