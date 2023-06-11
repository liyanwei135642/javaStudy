package com.lyw.study;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * IO学习
 * InputStream 字节输入流
 * OutputStream 字节输出流
 * FileInputStream 操作本地文件的字节输入流
 * FileOutputStream 操作本地文件的字节输出流
 *
 * Reader 字符输入流
 * writer 字符输出流
 * FileReader 操作本地文件的字符输入流
 * FileWriter 操作本地文件的字符输入流
 *
 * 字节流比字符流读写快得多！介意使用字节流 在内存阶段转换为字符串
 *
 */
public class IOStudy {
    public static void main(String[] args) throws IOException {
        //fileCopy2("myIo/test.txt","myIo/ccc.txt");
        //copypath("day01","day02");
        //putOrPopPassword("myIo/ccc.txt",18);
    }

    /**
     * FileOutputStream 操作本地文件的字节输出流
     * 操作步骤：
     *      创建对象
     *      写入数据
     *      释放资源
     */
    static void test1() throws IOException {
        //通过文件路径直接创建文件字节输出流对象 父文件夹不存在会抛出异常 默认不追加
        FileOutputStream fos=new FileOutputStream("myIo/test.txt",true);
        //写入数据
        byte[]bytes=new byte[1024*1024*5];
        for (int i = 0; i < bytes.length-1; i++) {
            bytes[i]='s';
        }
        //fos.write('\n');//输出一个字节
        long start=System.currentTimeMillis();
        fos.write(bytes,0,bytes.length);//输出字节数组从off索引开始的len个字节
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        String str="\nafafajjajahsjasja我为大家毁得很讲究";
        bytes=str.getBytes("utf8");
        fos.write(bytes);
        //释放资源
        fos.close();
    }

    /**
     * FileInputStream 操作本地文件的字节输入流
     * 操作步骤：
     *      创建对象
     *      读取数据
     *      释放资源
     */
    static void test2() throws IOException {
        //通过文件路径直接创建文件字节输入流对象 文件不存在会报错
        FileInputStream fis = new FileInputStream("myIo/test.txt");
        //读取数据
        char c=(char)fis.read();//读取一个字节 返回一个整形
        System.out.println(c);
        //释放资源
        fis.close();

        System.out.println("................");
        fis = new FileInputStream("myIo/test.txt");
        //读取数据
        byte[] bytes=new byte[1024];
        int read = fis.read(bytes);
        System.out.println(read);
        System.out.println(new String(bytes, 0, read));
        //释放资源
        fis.close();

        System.out.println("................");
        fis = new FileInputStream("myIo/test.txt");
        //读取数据
        bytes = fis.readNBytes(1000);//读取len个字节返回字节数组 大小等于实际读取的字节个数
        System.out.println(bytes.length);
        System.out.println(new String(bytes));
        //释放资源
        fis.close();


        System.out.println("................");
        fis = new FileInputStream("myIo/test.txt");
        //读取数据
        bytes = fis.readAllBytes();//读取全部字节返回字节数组
        System.out.println(bytes.length);
        System.out.println(new String(bytes));
        //释放资源
        fis.close();


    }

    //字节流文件拷贝
    static void fileCopy1(String src,String des) throws IOException {
        //创建文件字节出入流对象
        FileInputStream fr = new FileInputStream(src);
        FileOutputStream fw = new FileOutputStream(des);
        //读写文件
        //long start=System.currentTimeMillis();
        byte[] arr=fr.readAllBytes();
        fw.write(arr);
        //long end=System.currentTimeMillis();
        //System.out.println(end-start);
        //释放资源
        fr.close();
        fw.close();
    }


    /**
     * FileReader 操作本地文件的字符输入流
     * 操作步骤：
     *      创建对象
     *      读取数据
     *      释放资源
     */
    static void test3() throws IOException {
        //通过文件路径直接创建文件字符输入流对象 文件不存在会抛出异常 默认utf8编码
        FileReader fr = new FileReader("myIo/test.txt", UTF_8);
        //读取数据
        char c = (char) fr.read();//一次读取一个字符
        System.out.println(c);
        //释放资源
        fr.close();


        System.out.println("...................");
        fr=new FileReader("myIo/test.txt",Charset.forName("utf8"));
        char[] chars=new char[1024];
        int read = fr.read(chars, 0, chars.length);//一次读取多个字符到字符数组当中 返回实际读取的字符个数
        System.out.println(read);
        System.out.println(new String(chars,0,read));
        //释放资源
        fr.close();

        System.out.println("...................");
        fr=new FileReader("myIo/test.txt",Charset.forName("utf8"));
        chars=new char[1024*1024*5];
        while(true)
        {
            read = fr.read(chars, 0, chars.length);//一次读取多个字符到字符数组当中 返回实际读取的字符个数
            System.out.println(read);
            System.out.println(new String(chars,0,read));
            if(read<chars.length){
                break;
            }
        }
        //释放资源
        fr.close();


    }

    /**
     * FileWriter 操作本地文件的字符输出流
     * 操作步骤：
     *      创建对象
     *      读取数据
     *      释放资源
     */
    static void test4() throws IOException {
        //通过文件路径直接创建文件字符输出流对象 父文件路径不存在会抛出异常 默认不追加
        FileWriter fw = new FileWriter("myIo/test.txt", UTF_8,false);
        //读取数据
        char[] chars={'三','更','老','师','早'};
        fw.write('我');//一次写入一个字符
        fw.write("123456789李艳伟\n",0,13);//一次写入一个字符串
        fw.write(chars);//一次写入一个字符数组
        //释放资源
        fw.close();
    }

    //字符流文件拷贝
    static void fileCopy2(String src,String des) throws IOException {
        //创建文件字符出入流对象
        FileReader fr = new FileReader(src,UTF_8);
        FileWriter fw = new FileWriter(des,UTF_8,false);
        //读写文件
        char[]chars=new char[1024*1024*6];
        int read=0;
        //long start=System.currentTimeMillis();
        while((read=fr.read(chars))>0) {
            fw.write(chars,0,read);
        }
        //long end=System.currentTimeMillis();
        //System.out.println(end-start);
        //释放资源
        fr.close();
        fw.close();
    }

    //拷贝文件夹
    /**
     * 将 src 拷贝到 des下
     * @param src 要被拷贝的文件夹路径
     * @param des 要拷贝到的那个文件夹
     */
    static void copypath(String src,String des) throws IOException {
        File srcPath = new File(src);
        File desParent = new File(des);
        if(!srcPath.isDirectory()){
            return;
        }
        desParent.mkdirs();
        String name=srcPath.getName();
        File newpath = new File(desParent, name);
        newpath.mkdir();
        File[] files = srcPath.listFiles();
        for (File file : files) {
            if(file.isFile()){
                fileCopy1(file.getAbsolutePath(),newpath.getAbsolutePath()+"/"+file.getName());
            }else{
                copypath(file.getAbsolutePath(),newpath.getAbsolutePath());
            }
        }
    }

    //文件加密
    static void putOrPopPassword(String filepath,int password) throws IOException {
        FileInputStream file = new FileInputStream(filepath);
        byte[] bytes = file.readAllBytes();
        file.close();
        FileOutputStream newpath = new FileOutputStream(filepath);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]^=password;
        }
        newpath.write(bytes);
        newpath.close();
    }
}
