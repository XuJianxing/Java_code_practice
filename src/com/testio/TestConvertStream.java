package com.testio;

import java.io.*;

/** 转换流
 *  InputStreamReader/OutputStreamWriter用来实现将字节流转化成字符流。
 *
 */
public class TestConvertStream {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 使用字符输入和输出流
            String str = br.readLine();
            // 一直读取，直到用户输入了exit为止
            while (!"exit".equals(str)){
                // 写到控制台
                bw.write(str);
                bw.newLine();  // 写一行后换行
                bw.flush();  // 手动刷新
                str = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // 关闭字符输入和输出流
            if (br != null){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
