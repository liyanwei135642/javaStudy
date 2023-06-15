package com.lyw.reflect;

import com.lyw.net.TCPServer;
import com.lyw.study.MyAnnotation;
import com.lyw.study.Person;
import com.sun.tools.javac.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/** 反射学习
 * 获取某个类的类 类名.class 对象.getClass()
 * 利用反射创建了java 文档 Class\***.txt
 * 用下面静态方法将任意类的构造属性以及方法全部写入指定的文件
 * public static void saveObject(Class C,String filename)
 *
 *
 *
 */

public class MyReflect {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        saveObject(TCPServer.class,"Class\\TcpServer.txt");
    }

    private static void test1() {
        //获取字符串的类
        //Class<Main> c= Main.class;
        //获取字符串的所有public构造方法
//        Constructor[] cons = c.getConstructors();
//        for (Constructor con : cons) {
//            System.out.println(con);
//        }
        //获取字符串的所有构造方法
//        Constructor[] dcons = c.getDeclaredConstructors();
//        for (Constructor dcon : dcons) {
//            System.out.println(dcon);
//        }
        //获取字符串的所有public属性
//        Field[] fields = c.getFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }
        //获取字符串的所有属性
//        Field[] dfields = c.getDeclaredFields();
//        for (Field dfield : dfields) {
//            System.out.println(dfield);
//        }
        //获取字符串的所有public方法
//        Method[] methods = c.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
        //获取字符串的所有方
//        Method[] dmethods = c.getMethods();
//        for (Method dmethod : dmethods) {
//            System.out.println(dmethod);
//        }
        //获取指定的构造方法
        //Constructor constructor = c.getDeclaredConstructor();
        //System.out.println(constructor);

        //获取Person类的Class
//        Class<Person> C = Person.class;
//        //获取指定参数的私有构造方法
//        Constructor<Person> dc = C.getDeclaredConstructor(String.class, int.class);
//        //获取构造方法的参数
//        Parameter[] ps = dc.getParameters();
//        for (Parameter p : ps) {
//            System.out.println(p);
//        }
//        //获取构造方法的权限修饰符
//        int modifiers = dc.getModifiers();
//
//
//
//        //获取临时免除权限
//        dc.setAccessible(true);
//        //调用构造方法创建对象
//        Person p = dc.newInstance("liyanwei", 32);
//        System.out.println(p);
//
//        //获取私有属性并修改
//        Field name = C.getDeclaredField("name");
//        name.setAccessible(true);
//        name.set(p,"liuyongli");
//        System.out.println(p);

        //获取成员方法并且调用该方法
//        Method sb = c.getMethod("substring", int.class);
//        String str  = (String)sb.invoke("456789", 2);
//        System.out.println(str);

        //获取指定注解
        //MyAnnotation annotation = c.getAnnotation(MyAnnotation.class);
        //获取所有注解
        //Annotation[] annotations = c.getAnnotations();
        //解析注解
        //String name = annotation.name();
    }

    public static void saveObject(Class C,String filename) throws IllegalAccessException, IOException {
        Constructor[] cs = C.getDeclaredConstructors();
        Field[] fs = C.getDeclaredFields();
        Method[] ms = C.getDeclaredMethods();
        File file = new File(filename);
        String path = file.getAbsolutePath();
        int index = path.lastIndexOf('\\');
        path=path.substring(0,index);
        File dir = new File(path);
        dir.mkdirs();
        PrintWriter pw = new PrintWriter(new FileWriter(file, true));
        pw.println(C.getName()+":");
        for (int i = 0; i < cs.length; i++) {
            pw.printf("构造方法%d:\t%s\n",i+1,cs[i].toString());
        }
        for (int i = 0; i < fs.length; i++) {
            pw.printf("成员变量%d:\t%s\n",i+1,fs[i].toString());
        }
        for (int i = 0; i < ms.length; i++) {
            pw.printf("成员方法%d:\t%s\n",i+1,ms[i].toString());
        }
        pw.println("\n...................\n");
        pw.close();
    }



}
