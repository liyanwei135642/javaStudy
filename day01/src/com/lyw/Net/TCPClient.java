package com.lyw.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP客户端学习
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        start();
    }

    private static void start() throws Exception {
        //创建TCP客户端套接字
        //创建的同时会连接服务器 连接失败会报错
        Socket s=new Socket("127.0.0.1",51801);

        //获取输出流
        OutputStream os = s.getOutputStream();
        //获取输入流
        InputStream is = s.getInputStream();

        Scanner sc=new Scanner(System.in);

        byte[] bytes = new byte[1024];

        int len=0;

        try {
            while(true){
                //从键盘获取数据
                System.out.print("给服务器发送数据：");
                String str = sc.nextLine();
                if(str==""){continue;}
                //发送数据
                os.write(str.getBytes("utf8"));
                //接收数据
                len = is.read(bytes);
                if(len==0||len==-1){throw new Exception();}
                String text = new String(bytes, 0, len, "utf8");
                System.out.println("收到服务器回信：" + text);
            }
        } catch (Exception e) {
            s.close();
            System.out.println("服务器已经关闭！");
        }
    }
}
