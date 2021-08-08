package com.commonclass;

public class TestWrapper {
    public static void main(String[] args){
        // 基本数据类型转换成包装类对象
        Object int1 = new Integer(10);  // 已被抛弃
        Integer int2 = Integer.valueOf(20);
        // 字符串转成包装类
        String s = new String("123");
        Integer j = Integer.valueOf(s);

        Integer int3 = new Integer("1234");
        System.out.println(j);

        // 把包装类对象转成基本数据类型
        int int4 = int2.intValue();  //不必要的拆箱： int int4 = int2;
        double d = int2.doubleValue();

        // 包装类对象转成字符串
        String str = int1.toString();
        String str2 = int2.toString();
        System.out.println(str);
        System.out.println(str2);
    }

}
