package com.company;

public class TestString {
    public static void main(String[] args){
        String s = "strstrstr";
        String s2 = "str";
        String s3 = new String("str");

        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s2 == s3);  // false
        System.out.println(s2.equals(s3));  // true
        // 通常比较字符串时，使用equals  equals内部实现就是挨个比较字符是否相等
        System.out.println(s.equals(s3));

        System.out.println(s.charAt(2));
        System.out.println(s.equalsIgnoreCase(s2));//无视大小写的等于
        System.out.println(s.indexOf("tr"));//返回第一个子字符串位置索引
        System.out.println(s.length());

        // 会替换所有符合的 replaceAll是正则表达式替换
        String ss = s.replace("s","z");//产生新字符串，原字符串不变
        System.out.println(ss);
        System.out.println(s.toLowerCase()+s.toUpperCase());
        System.out.println(" a s d ".trim());//删除头部和尾部的空格
        System.out.println(s.startsWith("s"));
        System.out.println(s.substring(1,5));//下标子字符串
    }
}
