package com.testio;

import java.io.*;

/* 缓冲字符流  使用BufferedReader与BufferedWriter实现文本文件的复制
BufferedReader/BufferedWriter增加了缓存机制，大大提高了读写文本文件的效率，
同时，提供了更方便的按行读取的方法：readLine(); 处理文本时，我们一般可以使用缓冲字符流。
 */
public class TestBufferedReaderWriter {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String tempString = "";
        try {
            fr = new FileReader("a/ab/abc.txt");
            fw = new FileWriter("a/ab/cba.txt");
            // 使用缓冲字符流进行包装
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            // BufferedReader提供了更方便的readLine()方法，直接按行读取文本
            // br.readLine()方法的返回值是一个字符串对象，即文本中的一行内容
            while ((tempString = br.readLine()) != null){
                // 将读取的一行字符串写入文件中
                bw.write((tempString));
                // 下次写入之前先换行，否则会在上一行后边继续追加，而不是另起一行
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {  // 关闭文件
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
