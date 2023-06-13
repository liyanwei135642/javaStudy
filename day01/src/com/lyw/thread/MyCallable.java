package com.lyw.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+"-HelloWord");
        return 56;
    }
}
