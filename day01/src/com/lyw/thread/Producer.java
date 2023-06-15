package com.lyw.thread;

public class Producer extends Thread {
    private static int num=0;

    /**
     * 生产者模型
     */
    @Override
    public void run() {
            while(true){
                //基本方法
                /*synchronized (SharedData.products){
                    while(SharedData.products.size()==10){
                        try {
                            SharedData.products.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    SharedData.products.add(++num);
                    SharedData.products.notifyAll();
                    System.out.printf(getName()+":生产第%d一个产品,当前产品总数%d\n",num,SharedData.products.size());
                }*/

                int data=0;
                //阻塞队列
                try {
                    SharedData.queue.put(data=++num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
    }
}
