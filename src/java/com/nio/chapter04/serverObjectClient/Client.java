package com.nio.chapter04.serverObjectClient;

import java.io.*;
import java.net.Socket;

/**
 * @Description Client
 * @Author sunlei19
 * @Date 2020/9/8 16:43
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8088);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            System.out.println("客户端流开始=========");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            System.out.println("客户端流结束=========");
            for (int i = 0; i < 5; i++) {
                UserInfo newUserInfo = new UserInfo();
                newUserInfo.setId(i + 1);
                newUserInfo.setUserName("clientUserName" + (i + 1));
                newUserInfo.setPassword("clientPassword" + (i + 1));
                objectOutputStream.writeObject(newUserInfo);
                UserInfo userInfo = (UserInfo) objectInputStream.readObject();
                System.out.println("在客户端打印" + (i + 1) + ":" + userInfo.getId() + " " + userInfo.getUserName() + " " + userInfo.getPassword());
            }
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
