package com.lyw.study;

import java.util.*;

/**
 * 权重随机机器
 * @param <T>
 */
public class MyRandomer<T> {
    public static void main(String[] args){
        MyRandomer<String> mr=new MyRandomer();
        List<String>names=new ArrayList<>();
        List<Integer>wights=new ArrayList<>();
        Collections.addAll(names,"aaa","bbb","ccc","ddd");
        Collections.addAll(wights,0,1,9,9);
        System.out.println(mr.get(names,wights));
    }

    public MyRandomer() {
        this.map=new HashMap<>();
        this.arr=new ArrayList<>();
        this.random=new Random();
    }

    private HashMap<Integer, ArrayList<T>> map;
    private ArrayList<Integer> arr;
    private Random random;
    public  T get(List<T> list1, List<Integer>list2){
        int n=list1.size();
        if (n!=list2.size()){
            return null;
        }
        for (int i = 0; i < list1.size(); i++) {
            int k=list2.get(i);
            T t=list1.get(i);
            if(map.containsKey(k)){
                map.get(k).add(t);
            }else{
                ArrayList<T> v = new ArrayList<>();
                v.add(t);
                map.put(k,v);
            }

        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            int size = map.get(key).size();
            for (int j = 0; j < key*size; j++) {
                arr.add(key);
            }
        }
        int k1=random.nextInt(arr.size());
        int k2=arr.get(k1);
        ArrayList<T> ts = map.get(k2);
        return ts.get(random.nextInt(ts.size()));
    }
}
