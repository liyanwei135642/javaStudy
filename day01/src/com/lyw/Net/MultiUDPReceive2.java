package com.lyw.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * UDP通信协议学习之接收数据
 */
public class MultiUDPReceive2 {
    public static void main(String[] args) throws IOException {
        //创建组播套接字MulticastSocket
        //空参表示绑定默认端口
        //有参代表绑定指定端口
        int myPort=51801;
        MulticastSocket sk = new MulticastSocket(myPort);
        sk.joinGroup(InetAddress.getByName("224.0.0.1"));

        //打包数据报
        byte[]recs=new byte[1024];
        DatagramPacket rec=new DatagramPacket(recs,recs.length);

        Scanner s=new Scanner(System.in);
        System.out.printf("服务器已启动：正在监听%d端口！\n",myPort);

        while(true){
            //接收数据报
            sk.receive(rec);

            //解析数据报
            int len=rec.getLength();
            InetAddress address = rec.getAddress();
            int port = rec.getPort();

            //打印数据
            String text = new String(recs,0,len, "utf8");
            System.out.printf("收到消息来自%s:%d\t"+text,address,port);
            System.out.println("\n给对方回信："+text);

            //从键盘获取信息
            //String str=s.next();

            //原信息返回
            String str=text;

            //创建发送字节数组
            byte[] sends = str.getBytes("utf8");

            //打包发送数据报
            DatagramPacket send=new DatagramPacket(sends,sends.length,address,port);

            //发送数据报
            sk.send(send);
        }

        //关闭UDP套接字
        //sk.close();
    }
}
