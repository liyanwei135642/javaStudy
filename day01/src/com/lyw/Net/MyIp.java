package com.lyw.Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络编程学习
 * InetAddress 操作IP的类
 * InetAddress 的静态方法获取本机 InetAddress对象
 *         InetAddress ip = InetAddress.getLocalHost();
 *         InetAddress ip = InetAddress.getByName("127.0.0.1");
 *         InetAddress ip = InetAddress.getByName("192.168.2.4");
 *         InetAddress ip = InetAddress.getByName("DESKTOP-I9IL2KU");
 *         获取本机点分十进制ip地址
 *         System.out.println(ip.getHostAddress());
 *         获取ip地址的字节数组
 *         System.out.println(ip.getAddress());
 *         获取本机计算机名
 *         System.out.println(ip.getHostName());
 * 单播 普通网络传输都是单播 一对一
 * 组播 给指定的一组主机发送消息一对多
 *      组播地址 224.0.0.0-239.255.255.255
 *          其中224.0.0.0-224.0.0.255为组播预留地址
 * 广播 给局域网内所有主机发送消息
 *      广播地址255.255.255.255
 */
public class MyIp {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        //InetAddress ip = InetAddress.getByName("127.0.0.1");
        //InetAddress ip = InetAddress.getByName("192.168.2.4");
        //InetAddress ip = InetAddress.getByName("DESKTOP-I9IL2KU");
        System.out.println(ip);
        //获取本机点分十进制ip地址
        System.out.println(ip.getHostAddress());
        //获取ip地址的字节数组
        System.out.println(ip.getAddress());
        //获取本机计算机名
        System.out.println(ip.getHostName());





    }
}
