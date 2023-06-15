package com.lyw.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务器端学习
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        new TCPServer().start();
    }

    public  int port;

    public TCPServer() {
        this.port=51801;
    }

    /**
     *
     * @param port 绑定的端口号
     */
    public TCPServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        //创建TCP服务器端套接字 ServerSocket
        ServerSocket ss= null;
        while(true){
            try {
                ss = new ServerSocket(this.port);
            } catch (IOException e) {
                this.port+=1;
                System.out.println(this.port-1+"端口已经被其他程序绑定，正在尝试"+this.port+"端口");
                continue;
            }
            break;
        }
        System.out.printf("服务器启动,正在监听%d端口\n",this.port);
        //主线程等待连接到来并将连接交给其他线程维护
        while(true){
            //接收客户端的连接请求
            Socket accept = ss.accept();
            //创建线程处理连接
            TaskThread tt=new TaskThread(accept);
            //启动线程
            tt.start();
        }
    }




}
