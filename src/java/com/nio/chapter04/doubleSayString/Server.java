package com.nio.chapter04.doubleSayString;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            // 输入开始
            InputStream inputstream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputstream);
            int byteLength = objectInputStream.readInt();
            byte[] bytes = new byte[byteLength];
            objectInputStream.readFully(bytes);
            String newString = new String(bytes);
            System.out.println(newString);
            // 输入结束
            // 输出开始
            OutputStream outputStream = socket.getOutputStream();
            String strA = "客户端你好A\n";
            String strB = "客户端你好B\n";
            String strC = "客户端你好C\n";
            int allByteLength = (strA + strB + strC).getBytes().length;

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeInt(allByteLength);
            objectOutputStream.flush();
            objectOutputStream.write(strA.getBytes());
            objectOutputStream.write(strB.getBytes());
            objectOutputStream.write(strC.getBytes());
            objectOutputStream.flush();
            // 输出结束
            // 输入开始
            byteLength = objectInputStream.readInt();
            bytes = new byte[byteLength];
            objectInputStream.readFully(bytes);
            newString = new String(bytes);
            System.out.println(newString);
            // 输入结束
            // 输出开始
            String strD = "客户端你好D\n";
            String strE = "客户端你好E\n";
            String strF = "客户端你好F\n";
            allByteLength = (strD + strE + strF).getBytes().length;

            objectOutputStream.writeInt(allByteLength);
            objectOutputStream.flush();
            objectOutputStream.write(strD.getBytes());
            objectOutputStream.write(strE.getBytes());
            objectOutputStream.write(strF.getBytes());
            objectOutputStream.flush();

            inputstream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
