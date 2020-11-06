package com.nio.chapter05;

import java.net.Socket;

/**
 * @Description Test302
 * @Author sunlei19
 * @Date 2020/11/6 15:38
 * @Version 1.0
 */
public class Test302 {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 7777);
        socket.getOutputStream().write("12345".getBytes());
        socket.close();
    }
}
