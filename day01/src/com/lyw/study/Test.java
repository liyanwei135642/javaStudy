package com.lyw.study;

public class Test {
    public static void main(String[] args) {
        test();

    }

    static void test(){
        try{
            int n=4/0;
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("123");
    }

}
