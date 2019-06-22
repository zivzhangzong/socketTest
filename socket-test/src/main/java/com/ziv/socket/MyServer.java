package com.ziv.socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by HP on 2019/6/22.
 * 最简单的socket通信的服务端
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true){
            Socket socket = server.accept();
            new Thread(new MyDownLoad(socket)).start();
        }

    }
}
