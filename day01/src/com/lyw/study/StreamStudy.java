package com.lyw.study;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream 获取stream以及使用stream
 * stream 中数据改变不影响原来的集合
 */
public class StreamStudy {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        ArrayList<String> list=new ArrayList<>();
        Collections.addAll(list,"张无忌-45","张随山-32","李艳伟-22");
        //filter 中间方法 过滤掉不满足要求的数据
        //limit 只取前面limit个数据
        //skip 跳过前面skip个数据
        list.stream().filter(s-> s.matches("张.*")).limit(3).forEach(System.out::println);
        //map 中间方法 将流中的数据替换为新的数据类型
        list.stream().map( ss-> Integer.parseInt(ss.split("-")[1])).forEach(System.out::println);
        //distinct 去掉stream 流当中的重复数据 对于自定义数据需要重写hashCode()和equals()
        list.stream().distinct().forEach(System.out::println);
        //concat 将两个数据流合并
        Stream.concat(list.stream().skip(2),list.stream().limit(2)).forEach(System.out::println);
        //count 终结方法 统计总数
        System.out.println(list.stream().count());
        //toArray 终结方法 返回数组
        Integer[] arr = list.stream().map(ss -> Integer.parseInt(ss.split("-")[1])).toArray(n -> new Integer[n]);
        System.out.println(Arrays.toString(arr));
        //collect 终结方法 返回list集合
        List<Integer> list1 = list.stream().map(ss -> Integer.parseInt(ss.split("-")[1])).collect(Collectors.toList());
        System.out.println(list1);
        //collect 终结方法 返回set集合
        Set<Integer> set1 = list.stream().map(ss -> Integer.parseInt(ss.split("-")[1])).collect(Collectors.toSet());
        System.out.println(set1);
        //collect 终结方法 返回map集合
        Map<String, Integer> map1 = list.stream().distinct().collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[1])));
        System.out.println(map1);
        list.stream().forEach(new StreamStudy()::test);


        System.out.println(".................");


        System.out.println(Arrays.toString(list.stream().toArray(String[]::new)));
    }

    void test(String s){
        System.out.println(s);
    }
}
