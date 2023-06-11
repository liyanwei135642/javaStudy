package com.lyw.study;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * java的包装类基本都是将基本类型首字母大写
 * 例外 int Integer
 *      char Character
 *
 */
public class PackageClass {
    public static void main(String[] args) {
        int n= Integer.parseInt("123");
        System.out.println(n);
        double d=Double.parseDouble("456.3248");
        System.out.println(d);
        Byte b=127;
        System.out.println(Integer.toHexString(127));
        System.out.println(myToBinary(0xffffff));
    }

    public static String myToBinary(int num){
        ArrayList<Byte>arr=new ArrayList<Byte>();
        while(num!=0){
            int x=num%2;
            num/=2;
            arr.add((byte)x);
        }
        StringJoiner str=new StringJoiner("");
        int len=arr.size();
        for(int i=len-1;i>=0;i--){
            str.add(arr.get(i).toString());
        }
        return str.toString();
    }



}
