package com.lyw.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData {
    public static LinkedList<Integer> products=new LinkedList<>();

    public static ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(1);


}
