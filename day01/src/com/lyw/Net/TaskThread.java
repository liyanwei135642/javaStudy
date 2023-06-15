package com.lyw.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TaskThread extends Thread{
    private Socket sk;
    public TaskThread(Socket sk){
        this.sk=sk;
    }

    @Override
    public void run() {
        System.out.printf("收到来自 %s 的连接请求:\n",sk.getRemoteSocketAddress().toString());
        try{
            InputStream is=sk.getInputStream();
            OutputStream os = sk.getOutputStream();
            byte[] bytes = new byte[1024];
            int len=0;
            while(true){
                len = is.read(bytes);
                if(len==0||len==-1){throw new Exception();}
                String text=new String(bytes,0,len);
                System.out.println("\t"+sk.getRemoteSocketAddress().toString()+"\t"+text);
                //给对方回信
                os.write(text.getBytes("utf8"));
                System.out.println("\t来自"+sk.getRemoteSocketAddress().toString()+"的信息已处理");
            }
        }catch(Exception e){
            System.out.println(sk.getRemoteSocketAddress().toString()+"已经下线了！");
            try {
                sk.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
}
