package com.nio.chapter04.threadServer;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Description ReadRunnable
 * @Author sunlei19
 * @Date 2020/9/8 16:00
 * @Version 1.0
 */
public class ReadRunnable implements Runnable {

    private Socket socket;

    public ReadRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int readLength = inputStream.read(bytes);
            while (readLength != -1) {
                System.out.println(new String(bytes, 0, readLength));
                readLength = inputStream.read(bytes);
            }
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
