package com.lyw.thread;

public class ControlThread extends Thread{
    private MyThread[] threads;
    private int curnum;

    public ControlThread(MyThread[] threads) {
        this.threads = threads;
        this.curnum=threads.length;
    }

    @Override
    public void run() {
        while(this.curnum!=0){
            for (MyThread t : threads) {
                if(t.status==1){
                    System.out.println(t.getName()+":\t成功结束");
                    t.status=0;
                    this.curnum-=1;
                } else if (t.status==2) {
                    System.out.println(t.getName()+":\t失败结束");
                    t.status=0;
                    this.curnum-=1;
                }
            }
        }

    }
}
