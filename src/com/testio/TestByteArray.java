package com.testio;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* 简单测试ByteArrayInputStream 的使用
ByteArrayInputStream和ByteArrayOutputStream经常用在需要流和数组之间转化的情况!
说白了，FileInputStream是把文件当做数据源。
ByteArrayInputStream则是把内存中的”某个字节数组对象”当做数据源。
 */
public class TestByteArray {
    public static void main(String[] args) {
        byte[] b = "abcdefg".getBytes();
        test(b);
    }
    private static void test(byte[] b){
        ByteArrayInputStream bais = null;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int num = 0;  // 用于保存读取的字节数
        try {
            // 该构造方法的参数是一个字节数组，这个字节数组就是数据源
            bais = new ByteArrayInputStream(b);
            while ((temp = bais.read()) != -1){
                sb.append((char)temp);
                num++;
            }
            System.out.println(sb);
            System.out.println("读取的字节数："+num);
        }finally {
            try {
                if (bais != null){
                    bais.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
