package com.lyw.study;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
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
 * 字节流比字符流读写快得多！介意使用字节流 在内存阶段转换为字符串
 *
 * BufferedInputStream   字节输入缓冲流
 * BufferedOutputStream  字节输出缓冲流
 * BufferedReader        字符输入缓冲流
 * BufferedWriter        字符输出缓冲流
 * 缓冲流所谓的高级流自带缓冲区 其实如果一次性全部读取数据的话，还没有字节流效率高 一次少量读取的话缓冲流好点
 *
 * ObjectOutputStream    序列化输出流   操作对象的
 * ObjectInputStream     反序列化输入流   操作对象的
 * 被操作的对象必须要实现接口 implement Serializable接口 可序列化标记接口
 * 还需要在对象内部添加序列版本号属性例如 private static final long serialVersionUID = -5081282907286734349L;
 * 操作方式：在setting 中搜索Serializable 勾选最后一个....init....  还有jvm当中的....without...UID
 * transient 关键字表示 顺态属性 不会被序列化到本地文件
 * 如果需要序列化多个对象 就将多个对象放进list集合中
 *
 *  PrintOutputStream     字节打印输出流
 *  PrintWriter           字符打印输出流
 *  可以像System.out println()一样向指定的文件输出内容
 *  %s:字符串
 *  %nd:整形 至少n位
 *  %nf:小数 默认六位小数 至少占n位
 *  %10.5f:保留五位小数 至少占10位
 *  %x:十六进制
 *  %o:八进制
 *  %%:百分号
 *  %n:换行符
 *
 *
 *
 *
 */
public class IOStudy {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //fileCopy3("myIo/test.txt","myIo/ccc.txt");
        //copyPath("day01","day02");
        //putOrPopPassword("myIo/ccc.txt",18);
        //upZipDir("123.zip","day01/lib");
        zipFile("day01","test");


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
        fw.write(fr.readAllBytes());//一次读写全部
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
        char[]chars=new char[1024*1024*5];
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
    static void copyPath(String src,String des) throws IOException {
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
                copyPath(file.getAbsolutePath(),newpath.getAbsolutePath());
            }
        }
    }

    //文件加解密
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

    //字节缓冲流拷贝文件
    static void fileCopy3(String src,String des) throws IOException {
        //创建字节输入缓冲流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        //创建字节输出缓冲流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
        //读写数据
        //long start=System.currentTimeMillis();
        bos.write(bis.readAllBytes());//一次读写全部
        //long end=System.currentTimeMillis();
        //System.out.println(end-start);
        //释放出入流资源
        bis.close();
        bos.close();

    }

    //字符缓冲流效率并不比字符流高，多了readLine() 和 new line() 功能 其实没啥用 浪费内存
    static void test5() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("myIo/test.txt", UTF_8));
        String line=null;
        while ((line=br.readLine())!=null) {
            System.out.println(line);
        }
        br.close();
    }


    //序列化流与反序列化流
    static void test6() throws IOException, ClassNotFoundException {
        //创建可序列化的学生对象
        Student s1=new Student("liyanwei",(byte)32,"liulin");
        Student s2=new Student("liyanwei",(byte)32,"liulin");
        Student s3=new Student("liyanwei",(byte)32,"liulin");
        Student s4=new Student("liyanwei",(byte)32,"liulin");
        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students,s1,s2,s3,s4);
        System.out.println(students);

        //序列化 写入对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myIo/test.txt"));
        oos.writeObject(students);
        oos.close();

        //反序列化 读取对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myIo/test.txt"));
        students=(ArrayList<Student>) ois.readObject();
        ois.close();

        //输出结果
        System.out.println(students);
    }

    //字节打印流 字符打印流
    static void test7() throws IOException {
        //创建字节打印流
        PrintStream out1= new PrintStream("myIo/test.txt", "utf8");
        //创建字符打印流
        PrintWriter out2= new PrintWriter(new FileWriter("myIo/ddd.txt",UTF_8),true);
        out1.println("654879");
        out1.println("\t654879\t4567894");
        out1.println(96.3695);
        out1.printf("65487875%s%d\n","李艳伟",56);
        out1.printf("%10.3f %x",26.325874,127);
        out1.printf("%3d",2365);

        out2.println("654879");
        out2.println("\t654879\t4567894");
        out2.println(96.3695);
        out2.printf("65487875%s%d\n","李艳伟",56);
        out2.printf("%.3f %x",26.325874,127);
        //释放资源
        out1.close();
        out2.close();
    }

    /**
     * 解压缩流
     * 解压文件夹
     * src 原始压缩文件夹
     * des 解压目的地路径
     */
    static void upZipDir(String src ,String des) throws IOException {
        File file_src = new File(src);
        File file_des = new File(des);
        ZipInputStream zip = new ZipInputStream(new FileInputStream(file_src));
        ZipEntry entry=null;
        while ((entry=zip.getNextEntry())!=null) {
            if(entry.isDirectory()){
                File dir = new File(file_des, entry.getName());
                dir.mkdirs();
            }else{
                FileOutputStream fw = new FileOutputStream(new File(file_des, entry.getName()));
                fw.write(zip.readAllBytes());
                fw.close();
                zip.closeEntry();
            }
        }
        zip.close();
    }

    /**
     * 压缩文件
     * @param src 原始文件
     * @param des 压缩后的文件位置
     */
    static void zipFile(String src,String des) throws IOException {
        File file_src = new File(src);
        if(!file_src.exists()){
            return;
        }
        File file_des = new File(des);
        boolean b = file_des.mkdirs();
        String name=file_src.getName();
        if(file_src.isFile()){
            int i=name.lastIndexOf(".");
            name=name.substring(0,i)+".zip";
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(file_des, name)));
            ZipEntry ze=new ZipEntry(file_src.getName());
            zos.putNextEntry(ze);
            FileInputStream fr = new FileInputStream(file_src);
            zos.write(fr.readAllBytes());
            zos.closeEntry();
            zos.close();
            fr.close();
            return;
        }
        name=name+".zip";
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(file_des, name)));
        File[] files = FileStudy.test3(src);
        int i = files[0].getAbsolutePath().lastIndexOf('\\')+1;
        for (File file : files) {
            String path = file.getAbsolutePath().substring(i);
            if(file.isDirectory()){
                path+="/";
            }
            ZipEntry ze = new ZipEntry(path);
            zos.putNextEntry(ze);
            if(file.isFile()){
                FileInputStream fr = new FileInputStream(file);
                zos.write(fr.readAllBytes());
                zos.closeEntry();
                fr.close();
            }
        }
    }





}
