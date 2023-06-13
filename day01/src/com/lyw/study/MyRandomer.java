package com.lyw.study;

import java.util.*;

/**
 * 权重随机机器
 * @param <T>
 */
public class MyRandomer<T> {


    /**
     * 根据权重随机获取姓名
     * @param names 姓名数组
     * @param wights 权重数组
     * @return  姓名
     */
    public static Object getName(Object[] names,double[]wights){
        double[]ds1=new double[wights.length];
        ds1[0]=wights[0];
        double total=wights[0];
        for (int i = 1; i < wights.length; i++) {
            ds1[i]=ds1[i-1]+wights[i];
            total+=wights[i];
        }
        for (int i = 0; i < wights.length; i++) {
            ds1[i]=1.0*ds1[i]/total;
        }
        double d=Math.random();
        for (int i = 0; i < ds1.length; i++) {
            if(ds1[i]>d){
                return names[i];
            }
        }
        return null;
    }


    public static void main(String[] args){
        String[] names= {"aaa","bbb","ccc","ddd","eee"};
        double[]wights={1,2,3,4,5};
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < 1000000; i++) {
            String s=(String)getName(names, wights);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
            }
        }
        System.out.println(map);
    }

}
