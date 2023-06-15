package com.lyw.study;

import java.util.*;
import java.util.function.BiConsumer;

public class MapStudy {
    public static  void main(String[] args) {
        System.out.println(test2(1,1,4,9,6,3,2,5,8,7));
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,6,9,3,56,47,89,1,545646,259,3,0,1);
        Collections.shuffle(list);
        System.out.println(list);

    }

    public static void test1() {
        TreeMap<Character, Integer> m = new TreeMap<>();
        String str = "aababdjasgdhfdhfhhfdhgsfdhgfahsgachahfshgsacabcdabcde";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            boolean b = m.containsKey(c);
            if (b) {
                int v = m.get(c) + 1;
                m.put(c, v);
            } else {
                m.put(c, 1);
            }
        }
        TreeSet<Person> set = new TreeSet<>();
        Set<Character> keys = m.keySet();
        for (Character key : keys) {
            set.add(new Person());
        }
        for (Person p : set) {
            System.out.println(p.name + "(" + p.age + ")");
        }


    }

    public static int test2(int...args){
        int kkk=0;
        for (int i : args) {
            kkk+=i;
        }
        return kkk;
    }
}

