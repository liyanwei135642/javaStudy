package com.lyw.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式学习
public class ReStudy {
    public static void main(String[] args) {
        String text="aJavajkjkkjakjakkjak搭嘎广大顾客和旮旯好尬科技感科技噶价格将Java7jhgaglaglgajgjagjJava17dghagdagalka";
//        System.out.println("123456789".matches("\\d{0,20}"));
//        //创建正则表达式p
//        Pattern p=Pattern.compile("Java\\d{1,2}");
//        //获取文本匹配器m
//        Matcher m=p.matcher(text);
//        while(m.find()){
//            String s=m.group();
//            System.out.println(s);
//        }
        String[] arr=findAll(text,"Java\\d{0,2}");
        System.out.println(Arrays.toString(arr));
    }

    public static String[] findAll(String text,String rex){
        ArrayList<String>arr=new ArrayList<>();
        Matcher m=Pattern.compile(rex).matcher(text);
        while(m.find()){
            arr.add(m.group());
        }
        int n=arr.size();
        String[] ret=new String[n];
        for (int i = 0; i < ret.length; i++) {
            ret[i]=arr.get(i);
        }
        return ret;
    }


}
