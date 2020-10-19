package com.nio.chapter05;

import java.io.IOException;
import java.net.Socket;

public class Test203 {
    public static void main(String[] args) throws IOException {

        Socket socket8888 = new Socket("localhost", 8888);
        socket8888.close();

        Socket socket9999 = new Socket("localhost", 9999);
        socket9999.close();
    }
}
