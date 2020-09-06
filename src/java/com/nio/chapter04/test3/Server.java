package com.nio.chapter04.test3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 验证inputstream.read有阻塞效果
 */
public class Server {
    public static void main(String[] args) {
        try {
            char[] chars = new char[1024];
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("accept begin " + System.currentTimeMillis());
            Socket socket = serverSocket.accept();// 呈阻塞状态
            System.out.println("accept end " + System.currentTimeMillis());
            InputStream inputstream = socket.getInputStream();
            System.out.println("read begin " + System.currentTimeMillis());

            InputStreamReader inputStreamReader = new InputStreamReader(inputstream);
            int readlength = inputStreamReader.read(chars);
            while (readlength != -1) {
                String newString = new String(chars, 0, readlength);
                System.out.println(newString);
                readlength = inputStreamReader.read(chars);
            }

            System.out.println("read end " + System.currentTimeMillis());
            inputStreamReader.close();
            inputstream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
