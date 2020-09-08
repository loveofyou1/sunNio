package com.nio.chapter04.test8;

import java.io.IOException;
import java.net.Socket;

/**
 * @Description BackLogClietn
 * @Author sunlei19
 * @Date 2020/9/8 20:49
 * @Version 1.0
 */
public class BackLogClient {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 2000; i++) {
            Socket socket = new Socket("localhost", 8888);
            System.out.println("client send request =" + i);
        }
    }
}
