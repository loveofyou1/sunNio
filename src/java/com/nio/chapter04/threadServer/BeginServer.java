package com.nio.chapter04.threadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description BeginServer
 * @Author sunlei19
 * @Date 2020/9/8 15:52
 * @Version 1.0
 */
public class BeginServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            int runTag = 1;
            while (runTag == 1) {
                Socket socket = serverSocket.accept();
                BeginThread beginThread = new BeginThread(socket);
                beginThread.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
