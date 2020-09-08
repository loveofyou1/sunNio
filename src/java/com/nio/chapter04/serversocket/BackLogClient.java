package com.nio.chapter04.serversocket;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description BackLogClietn
 * @Author sunlei19
 * @Date 2020/9/8 20:25
 * @Version 1.0
 */
public class BackLogClient {

    public static void main(String[] args) {
        try {
            Socket socket1 = new Socket("localhost", 8088);
            Socket socket2 = new Socket("localhost", 8088);
            Socket socket3 = new Socket("localhost", 8088);
            Socket socket4 = new Socket("localhost", 8088);
            Socket socket5 = new Socket("localhost", 8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
