package com.nio.chapter05;

import java.io.IOException;
import java.net.Socket;

public class Test202 {
    public static void main(String[] args) throws IOException {

        Socket socket7777 = new Socket("localhost", 7777);
        socket7777.close();
    }
}
