package com.lyw.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义线程类
 */
public class MyThread extends Thread{
    public int status;

    public int[] tickets;

    //用 synchronized 关键字加锁 需要一个共享的被锁对象 所以添加静态变量 lock
    private static Object lock=new Object();

    //用Lock锁解决线程安全 所以添加静态变量 lock2
    private static Lock lock2=new ReentrantLock();

    public MyThread(int[] tickets){
        this.tickets=tickets;
    }

    public MyThread() {
    }

    @Override
    public void run() {
        while(true){

            //同步方法 用 synchronized 给方法加锁
            //if (task()) break;

            //同步代码块 用 synchronized 给代码块加锁
            /*synchronized (lock){
                if(tickets[0]<=0){
                    break;
                }
                System.out.printf(getName()+": 卖出第%d张票\n",101-tickets[0]);
                tickets[0]-=1;
            }*/

            //用 Lock 给代码块加锁
            lock2.lock();
            if(tickets[0]<=0){
                lock2.unlock();
                break;
            }
            System.out.printf(getName()+": 卖出第%d张票\n",101-tickets[0]);
            tickets[0]-=1;
            lock2.unlock();
            try {
                sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        status=1;
    }

    private synchronized boolean task() {
        if(tickets[0]<=0){
            return true;
        }
        System.out.printf(getName()+": 卖出第%d张票\n",101-tickets[0]);
        tickets[0]-=1;
        return false;
    }
}
