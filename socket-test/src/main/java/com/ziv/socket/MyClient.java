package com.ziv.socket;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by HP on 2019/6/22.
 * 最简单的socket通信的客户端
 */
public class MyClient {


    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",9999);
        InputStream inputStream = client.getInputStream();
        byte[] b = new byte[100];
        int len = -1;

        FileOutputStream fileOutputStream = new FileOutputStream(new File("d:\\fanmian.jpg."));

        while ((len = inputStream.read(b)) != -1){
            fileOutputStream.write(b,0,len);
        }
        System.out.println("文件写入完毕");
        fileOutputStream.close();
        inputStream.close();
        client.close();
    }


}
