package com.lyw.thread;

public class MyRunable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            //获取当前线程(哪个线程正在执行这行代码就能获取哪个线程的对象)
            Thread t = Thread.currentThread();
            System.out.printf(t.getName()+"-HelloWord-%d\n",i+1);
        }
    }
}
