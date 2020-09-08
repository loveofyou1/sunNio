package com.nio.chapter04.transferFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 10:17
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            String fileName = "C:\\Users\\sunlei19\\Pictures\\upload.jpg";
            FileInputStream inputStream = new FileInputStream(new File(fileName));
            byte[] bytes = new byte[2048];
            System.out.println("socket begin " + System.currentTimeMillis());

            Socket socket = new Socket("localhost", 8088);
            System.out.println("socket end " + System.currentTimeMillis());

            OutputStream outputStream = socket.getOutputStream();
            int readLength = inputStream.read(bytes);
            while (readLength != -1) {
                outputStream.write(bytes, 0, readLength);
                readLength = inputStream.read(bytes);
            }
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
