package com.nio.chapter04.serverObjectClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description Server
 * @Author sunlei19
 * @Date 2020/9/8 16:38
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            System.out.println("服务端流开始=========");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            System.out.println("服务端流结束=========");
            for (int i = 0; i < 5; i++) {
                UserInfo userInfo = (UserInfo) objectInputStream.readObject();
                System.out.println("服务端打印" + (i + 1) + ":" + userInfo.getId() + " " + userInfo.getUserName() + " " + userInfo.getPassword());
                UserInfo newUserInfo = new UserInfo();
                newUserInfo.setId(i + 1);
                newUserInfo.setUserName("serverUserName" + (i + 1));
                newUserInfo.setPassword("serverPassword" + (i + 1));
                objectOutputStream.writeObject(newUserInfo);
            }

            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
