package com.nio.chapter05;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Test1_Client1 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);

        String str = "test nihao";
        outputStreamWriter.write(str.toCharArray());

        outputStreamWriter.close();
        outputStream.close();
        socket.close();

    }
}
