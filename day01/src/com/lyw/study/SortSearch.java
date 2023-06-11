package com.lyw.study;

import java.util.Arrays;
import java.util.Comparator;

public class SortSearch {


    public static void main(String[] args) {
        Integer[]arr={9,5,6,3,2,4,7,1,0,8};
        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr, 0, 5, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                //return o2-o1;降序
//                return o1-o2;
//            }
//        });
        //lamada表达式
        Arrays.sort(arr,(a,b)->{
            return a-b;
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr,7));
        Integer[] aa=Arrays.copyOf(arr,20);
        arr[0]=89;
        System.out.println(Arrays.toString(aa));
        System.out.println(Arrays.toString(arr));
    }
}
