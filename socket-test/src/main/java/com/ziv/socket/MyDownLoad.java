package com.ziv.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by HP on 2019/6/22.
 * 利用socket实现文件下载
 */
public class MyDownLoad implements Runnable {
    private Socket socket;
    public MyDownLoad(Socket socket){
        this.socket = socket;
    }
    public void run() {
        System.out.println("监听到来自客户端的请求");
        OutputStream outputStream = null;
        FileInputStream fileInputStream =null;

        try {
            outputStream = socket.getOutputStream();
            System.out.println("发送文件~~~");
            File file = new File("d:\\fan.jpg");
             fileInputStream = new FileInputStream(file);
            byte[] b = new byte[100];
            int len = -1;
            while ( (len =fileInputStream.read(b)) != -1){
                outputStream.write(b,0,len);
            }
            System.out.println("文件发送完毕~~~~");
            fileInputStream.close();
            outputStream.close();
            socket.close();;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
