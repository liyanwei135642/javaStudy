package com.lyw.Net;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP通信协议学习之发送数据
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        //创建UDP套接字DatagramSocket
        //空参表示绑定默认端口
        //有参代表绑定指定端口
        DatagramSocket sk = new DatagramSocket();

        Scanner s=new Scanner(System.in);

        //设置目的地IP地址
        InetAddress remoteIp = InetAddress.getByName("127.0.0.1");

        //设置目的地端口号
        int remotePort=51801;

        //打包接收数据报
        byte[]recs=new byte[1024];
        DatagramPacket rec=new DatagramPacket(recs,recs.length);

        while(true){
            //从键盘获取信息
            System.out.print("给服务器发送：");
            String str=s.next();

            //创建发送字节数组
            byte[] sends = str.getBytes("utf8");

            //打包发送数据报
            DatagramPacket send=new DatagramPacket(sends,sends.length,remoteIp,remotePort);

            //发送数据报
            sk.send(send);

            //接收数据报
            sk.receive(rec);

            //解析数据报
            int len=rec.getLength();

            //打印数据
            String text = new String(recs,0,len, "utf8");
            System.out.println("收到服务器回信:"+text);
        }

        //关闭UDP套接字
        //sk.close();


    }
}
