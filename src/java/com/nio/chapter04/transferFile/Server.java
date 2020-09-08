package com.nio.chapter04.transferFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description Server
 * @Author sunlei19
 * @Date 2020/9/8 10:13
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            byte[] bytes = new byte[2048];
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            System.out.println("socket connet begin " + System.currentTimeMillis());
            InputStream inputStream = socket.getInputStream();

            System.out.println("socket connect end " + System.currentTimeMillis());
            System.out.println("output new picture begin ");
            int readLength = inputStream.read(bytes);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\sunlei19\\Pictures\\new.jpg"));
            while (readLength != -1) {
                fileOutputStream.write(bytes, 0, readLength);
                readLength = inputStream.read(bytes);
            }
            System.out.println("output new picture end ");
            fileOutputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
