package com.lyw.thread;

public class Customer extends Thread{


    /**
     * 消费者模型
     */
    @Override
    public void run(){
        while(true){
            //基本方法
            /*synchronized (SharedData.products){
                if(SharedData.products.size()==0){
                    try {
                        SharedData.products.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Integer pop = SharedData.products.pop();
                SharedData.products.notifyAll();
                System.out.printf(getName()+":买到第%d个产品\n",pop);
            }*/

            int data=0;

            //阻塞队列
            try {
                data = SharedData.queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
