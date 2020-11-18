package com.nio.chapter06.part2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description Test2
 * @Author sunlei19
 * @Date 2020/11/18 17:55
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我来自客户端1".getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
