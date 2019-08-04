package com.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class TestDatagramChannel {
    public static void main(String[] args) {

    }

    private static void conn() {
        try {
            //open DatagramChannel
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.bind(new InetSocketAddress(9999));

            //receive buffer datas
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            datagramChannel.receive(buf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sent() {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            String newData = "New String to write to file..." + System.currentTimeMillis();

            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());
            buf.flip();
            int bytesSent = datagramChannel.send(buf, new InetSocketAddress("jenkov.com", 80));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
