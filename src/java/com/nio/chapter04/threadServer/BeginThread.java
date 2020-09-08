package com.nio.chapter04.threadServer;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Description BeginThread
 * @Author sunlei19
 * @Date 2020/9/8 15:53
 * @Version 1.0
 */
public class BeginThread extends Thread {

    private Socket socket;

    public BeginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] chars = new char[1024];
            int readLength = -1;
            while ((readLength = inputStreamReader.read(chars)) != -1) {
                String newString = new String(chars, 0, readLength);
                System.out.println(newString);
            }
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
