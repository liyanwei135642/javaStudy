package com.lyw.study;

/**
 * 单例设计 饿汉模式 类一加载就创建对象 开发中推介使用恶汉模式 可以避免多线程的线程安全问题
 */
public class SingleHungry {
    /**
     * 将构造方法私有化
     */
    private SingleHungry(){}

    /**
     * 创建私有的自己类的静态变量
     */
    private static SingleHungry s=new SingleHungry();

    /**
     * 获取单例对象
     * @return
     */
    public static SingleHungry getInstance(){
        return s;
    }




}
