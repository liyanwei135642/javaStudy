package com.lyw.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * Date类学习
 * 世界标准时间UTC 用原子钟记录 误差两千万年一秒钟
 * 中国在东八区 比标准时间晚八个小时
 * 时间原点1970年0时0分0秒 我国1970年8时0分0秒
 *
 */
public class DateStudy {
    public static void main(String[] args) throws ParseException {
        Date d=new Date(0);
        d.setTime(365L*24*60*60*1000);
        System.out.println(d);


        //SimpleDateFormat类用来解析Date类
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EE");
        System.out.println(sd.format(d));
        Date dd=sd.parse("2023-06-08 08:09:56 周一");
        System.out.println(sd.format(dd));

        Calendar a=Calendar.getInstance();
        a.setTimeInMillis(0);
        System.out.println(a);
        System.out.println(a.get(Calendar.YEAR));
        a.set(Calendar.YEAR,2023);
        System.out.println(a.get(Calendar.YEAR));

        //获取java许可的所有时区
        Set<String> arr=ZoneId.getAvailableZoneIds();
        for (String s : arr) {
            System.out.println(s);
        }
        //获取当前系统默认的时区
        ZoneId zi_d=ZoneId.systemDefault();
        //获取指定的时区
        ZoneId zi=ZoneId.of("Asia/Shanghai");
        System.out.println(zi+" "+zi_d);

        Instant is=Instant.now();
        System.out.println(is);










    }
}
