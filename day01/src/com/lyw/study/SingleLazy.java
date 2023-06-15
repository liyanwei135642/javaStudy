package com.lyw.study;

/**
 * 单例设计 懒汉模式 用的时候才创建对象 开发中不推介使用懒汉模式 因为多线程的线程安全问题
 */
public class SingleLazy {
    private SingleLazy(){}

    private static SingleLazy s=null;

    public static SingleLazy getInstance(){
        if(s==null){
            s=new SingleLazy();
        }
        return s;
    }
}
