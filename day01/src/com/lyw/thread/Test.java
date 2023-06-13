package com.lyw.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程的第一种启动方式
 *      1.自定义一个类去继承Thread
 *      2.重写run()方法
 *      3.创建自定义类的实例对象
 *      4.调用start()方法启动线程
 * 多线程的第二种启动方式
 *      1.自定义一个类实现Runable接口
 *      2.重写run()方法
 *      3.创建自定义类的对象
 *      4.用 new Thread(自定义类对象) 创建Thread对象
 *      5.调用Thread对象的start()方法启动线程
 * 用Thread的静态方法获currentThread()取当前线程(哪个线程正在执行这行代码就能获取哪个线程的对象)
 *       Thread t = Thread.currentThread();
 * 多线程的第三种启动方式
 *      1.为了实现有返回值才出现的 其实我自己就可以写更好的有返回值的类，有点鸡肋 不好用
 *      2.创建一个类实现Callable接口
 *      3.重写call()方法 有返回值
 *      4.创建自定义类的对象 mc
 *      5.创建Future对象 Future是一个接口 所以创建它的实现类 FutureTask对象 FutureTask(mc)
 *      6.创建Thread对象 用ft构造 Thread(ft)
 *
 * Thread 成员方法：
 *      1.public static native Thread currentThread(); 静态方法 获取当前正在执行的线程对象
 *      2.public static native void sleep(long millis) ;静态方法 让当前线程休眠 millis 毫秒
 *      3.public final synchronized void setName(String name); 设置线程的名字
 *      4.public final String getName(); 获取线程的名字
 *      5.public final void setPriority(int newPriority); 设置线程的优先级 0-10 10最高 默认5
 *      6.public final int getPriority(); 获取线程的优先级
 *      7.public final void setDaemon(boolean on); 设置守护线程 其他非守护线程结束以后 守护线程没有存在的必要,会自动结束
 *      8.public static native void yield(); 静态方法 让出当前线程的cpu执行权
 *      9.public final void join(); 插入线程 将调用该方法的线程插入到当前线程之前
 * 线程安全问题
 *      1.用 synchronized 关键字加锁
 *      2. 给代码块加锁 synchronized(要锁的对象){线程执行共享资源的代码} 要锁的对象不一定非的是代码操作对象 只要是所有线程共有的就可以
 *      3. 给方法加锁 private synchronized boolean task();
 *      4.StringBuilder 线程不安全  Stringbuffer 线程安全
 *      5.lock锁 Lock是个接口 要用它的实现类 ReentrantLock
 *
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //test1();
        //test2();
        int[] tickets={100};
        MyThread[] threads=new MyThread[10];
        for (MyThread thread : threads) {
            thread=new MyThread(tickets);
            thread.start();
        }

    }

    private static void test2() throws InterruptedException {
        System.out.println("start");
        //获取当前线程
        Thread t=Thread.currentThread();
        System.out.println(t.getPriority());
        //设置线程的优先级最高
        t.setPriority(10);
        System.out.println(t.getPriority());
        System.out.println("end");
        MyThread t1=new MyThread();
        //设置为守护线程
        t1.setDaemon(true);
        t1.start();
        //让当前线程休眠2000ms
        Thread.sleep(1000);
    }

    private static void test1() throws InterruptedException, ExecutionException {
        //获取当前主线程
        Thread t=Thread.currentThread();
        //输出线程的名字
        System.out.println(t.getName());
        MyThread t1=new MyThread();
        t1.start();
        MyRunable r1=new MyRunable();
        Thread t2=new Thread(r1);
        //设置线程的名字
        t2.setName("新线程");
        t2.start();
        MyThread[] threads=new MyThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i]=new MyThread();
            threads[i].start();
        }
        //自定义的线程管理工具 处理线程运行结果 比第三种方式好得多(个人感觉)
        ControlThread ct=new ControlThread(threads);
        ct.start();
        //测试第三种线程启动方式
        MyCallable mc=new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread tt=new Thread(ft);
        tt.start();
        System.out.println(ft.get());
    }
}
