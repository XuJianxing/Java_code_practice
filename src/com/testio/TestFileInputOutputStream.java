package com.testio;
/*
FileInputStream通过字节的方式读取文件，适合读取所有类型的文件(图像、视频、文本文件等)。
Java也提供了FileReader专门读取文本文件。
FileOutputStream 通过字节的方式写数据到文件中，适合所有类型的文件。
Java也提供了FileWriter专门写入文本文件。
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputOutputStream {
    public static void testFileInputStream(){
        // 使用流读取文件内容，经典代码
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("a/b/c/d.txt");

            StringBuilder sb = new StringBuilder();
            int temp = 0;
            // 当temp==-1时表示已经到了文件结尾，停止读取
            while ((temp = fis.read()) != -1){
                sb.append( (char) temp);  //把读取的int值转为char
            }
            System.out.println(sb);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // finally里也加了try， 为了保证出现异常后流的正常关闭，
            // 通常要将流的关闭语句要放到finally语句块中，并且要判断流是不是null。
            try {
                if (fis != null){
                    fis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void testFileOutputStream(){
        FileOutputStream fos = null;  // 必须先初始化 为null
        String str = "zxcv指向bnm";
        try{
            // true表示内容会追加到文件末尾；false表示重写整个文件内容。
            fos = new FileOutputStream("a/ab/abc.txt", true);
            //该方法是直接将一个字节数组写入文件中; 而write(int n)是写入一个字节
            fos.write(str.getBytes());
            fos.write("\n".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fos != null) fos.close();  // 否则fos可能未被初始化，不能编译通过
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        testFileInputStream();
        testFileOutputStream();
    }
}
