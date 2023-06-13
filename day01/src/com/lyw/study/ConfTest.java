package com.lyw.study;

import java.io.*;
import java.util.Properties;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Properties 测试
 * 用于配置文件的
 */
public class ConfTest {
    public static void main(String[] args) throws IOException {
        Properties prop=new Properties();
        prop.put("name","李彦伟");
        prop.put("age","32");
        prop.put("sex","男");
        System.out.println(writeConf(prop, "day01/conf/myprop.properties"));
        prop = readConf("day01/conf/myprop.properties");
        if(prop!=null){
            System.out.println(prop);
        }
    }

    /**
     * 写配置到指定的配置文件
     * @prop 配置内容
     * @path 配置文件的路径
     */
    public static boolean writeConf(Properties prop,String path) throws IOException {
        if(prop==null){
            System.err.println("prop不能为空！");
            return false;
        }
        File file = new File(path);
        path=file.getAbsolutePath();
        int i = path.lastIndexOf('\\');
        String parent = path.substring(0, i);
        File file1 = new File(parent);
        file1.mkdirs();
        FileOutputStream fos = new FileOutputStream(file, false);
        //FileWriter fos = new FileWriter(file,UTF_8,false);
        prop.store(fos,"lyw");
        fos.close();
        return true;
    }

    /**
     * 从指定的配置文件读取配置
     * @param path 配置文件的位置
     * @return Properties对象
     */
    public static Properties readConf(String path) throws IOException {
        Properties prop=new Properties();
        File file = new File(path);
        if(!file.exists()){
            System.err.println("配置文件不存在！");
            return null;
        }
        FileInputStream fis = new FileInputStream(file);
        //FileReader fis = new FileReader(file, UTF_8);
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("配置文件格式错误！");
            fis.close();
            return null;
        }
        fis.close();
        return prop;
    }

    /**
     * 追加配置到指定的配置文件
     * @prop 要追加的配置内容
     * @path 配置文件的路径
     */
    public static boolean appendConf(Properties prop,String path) throws IOException {
        if(prop==null){
            System.err.println("prop不能为空！");
            return false;
        }
        File file = new File(path);
        path=file.getAbsolutePath();
        int i = path.lastIndexOf('\\');
        String parent = path.substring(0, i);
        File file1 = new File(parent);
        file1.mkdirs();
        FileOutputStream fos = new FileOutputStream(file, true);
        //FileWriter fos = new FileWriter(file,UTF_8,true);
        prop.store(fos,"lyw");
        fos.close();
        return true;
    }

}
