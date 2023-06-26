package com.lyw.pojo;

import java.util.Arrays;

public class User {
    private String name= "liyanwei";
    private int age;
    private Addr addr;


    public User() {
        System.out.println("空参构造");
        System.out.println(name);
    }

    public User(String name, int age, Addr addr) {
        System.out.println("全参构造");
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        System.out.println("获取name");
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        System.out.println("设置name:"+name);
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        System.out.println("获取age");
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        System.out.println("设置age:"+age);
        this.age = age;
    }

    /**
     * 获取
     * @return addr
     */
    public Addr getAddr() {
        return addr;
    }

    /**
     * 设置
     * @param addr
     */
    public void setAddr(Addr addr) {
        this.addr = addr;
    }

    public String toString() {
        return "User{name = " + name + ", age = " + age + ", addr = " + addr + "}";
    }

    public String getTest(){
        System.out.println("获取test");
        return "123";
    }

    public void setTest(String s){
        System.out.println("设置test:"+s);
    }
}
