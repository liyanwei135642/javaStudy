package com.lyw.study;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

/**
 * 文件学习
 */
public class FileStudy {


    public static void main(String[] args) throws IOException {
        delete("aaa6");


    }

    private static void test1() {
        //根据字符串路径创建文件对象
        File file1 = new File("mygit.java");//相对路径
        File file2 = new File("C:\\Users\\67021\\Desktop\\javaStudy\\filetest2.txt");//绝对路径
        File file3 = new File("C:\\Users\\67021\\Desktop", "javaStudy\\filetest3.txt");//父路径+子路径
        File file = new File("day01");
        File file4 = new File(file, "filetest4.txt");//父文件对象+子路径
    }

    private static void test2() throws IOException {
        String dir="aaa/bbb/ccc";
        String file="test.txt";
        File dirpath = new File(dir);
        File fileName = new File(dirpath, file);
        if(!dirpath.exists()){
            dirpath.mkdirs();//创建多级路径
        }
        if(!fileName.exists()){
            fileName.createNewFile();//创建文件
        }
        String path = fileName.getAbsolutePath();
        File f1 = new File("C:\\Users\\67021\\Desktop\\javaStudy");
        System.out.println(f1);
        File[] files = f1.listFiles();//获取f1 文件内部的所有子文件
        for (File file1 : files) {
            System.out.println(file1);
        }
        File[] files1 = File.listRoots();//获取所有盘符
        for (File file1 : files1) {
            System.out.println(file1);
        }
        f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println((name + dir));

                return false;
            }
        });//文件过滤器

        f1.list(FileStudy::filter);





    }
    static boolean filter(File dir,String name){
        System.out.println(name);
        return true;
    }

    //遍历文件夹下面所有的内容
    static File[] test3(String dir){
        ArrayList<File> ret=new ArrayList<File>();
        File path = new File(dir);
        ret.add(path);
        File[] files = path.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                Collections.addAll(ret,test3(f.getAbsolutePath()));
            }else{
                ret.add(f);
            }
        }
        return ret.toArray(File[]::new);
    }

    //遍历文件夹下面所有的内容 带过滤器寻找目标文件
    static File[] test4(String dir,String rex){
        ArrayList<File> ret=new ArrayList<File>();
        File path = new File(dir);
        File[] files = path.listFiles((root,name)->{
            if(name.matches(rex)){
                return true;
            }
            return new File(root,name).isDirectory();
        });
        for (File f : files) {
            if(f.isDirectory()){
                Collections.addAll(ret,test4(f.getAbsolutePath(),rex));
            }else{
                ret.add(f);
            }
        }
        return ret.toArray(File[]::new);
    }

    //删除文件
    static void delete(String path){
        File root = new File(path);
        if(!root.exists()){
            return;
        }
        File[] files = root.listFiles();
        for (File file : files) {
            if(file.isFile()){
                file.delete();
            }else{
                delete(file.getAbsolutePath());
            }
        }
        root.delete();
    }

}
