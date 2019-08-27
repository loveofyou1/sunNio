package com.test;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class DownLoadImage {
    public static void main(String[] args) {
        String url = "http://pic41.nipic.com/20140508/18609517_112216473140_2.jpg";
        String path = "/用户/sunlei/pic.jpg";
        download(url, path);
    }

    private static void download(String urlList, String desc) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(desc));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            System.out.println("下载图片到数据流");
            while ((length = dataInputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            System.out.println("写数据流到文件输出流");
            fileOutputStream.write(outputStream.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
