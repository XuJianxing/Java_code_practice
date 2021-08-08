package com.commonclass;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
// 时间对象和字符串互相转换
// .parse(): 字符串转成Date对象  .format(): Date对象转成字符串
import java.text.SimpleDateFormat;  // 继承自DateFormat抽象类;

public class TestDate {
    public static void main(String[] args){
        Date d = new Date(3000);  // 定义Date的时候给了初始化毫秒数
        System.out.println(d);
        System.out.println(d.getTime());  // getTime()方法是获得long毫秒数时间

        Date d2 = new Date();
        System.out.println(d2);
        System.out.println(d2.getTime());
        System.out.println(d2.toString());
        System.out.println(d2.after(d));  // 传进一个Date对象

        DateFormat df = new SimpleDateFormat();
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
        // 将时间对象转换成字符串
        //用SimpleDateFormat类的对象里的format()方法传入时间对象转换返回字符串
        String date = df.format(d2);
        System.out.println("df:"+date);
        System.out.println("df1:"+df1.format(d2));
        System.out.println("df2:"+df2.format(d2));
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));
        // 将符合指定格式的字符串转成时间对象，字符串格式需要和指定格式一致
        String s;
        s = df2.format(d2);
        try {
            Date d3 = df2.parse(s);
            System.out.println("d3 parse："+d3);
            Date d4 = df2.parse("2000年1月1日");
            System.out.println("d4："+d4);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
