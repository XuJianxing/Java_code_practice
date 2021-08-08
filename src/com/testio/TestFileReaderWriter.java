package com.testio;
/*前面介绍的文件字节流可以处理所有的文件，但是字节流不能很好的处理Unicode字符，经常会出现“乱码”现象。
所以，我们处理文本文件，一般可以使用文件字符流，它以字符为单位进行操作。
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReaderWriter {

    public static void testFileReaderWriterCopy(){
        // 写法和使用Stream基本一样，只不过，读取时是读取的字符。
        FileReader fr = null;
        FileWriter fw = null;
        int len = 0;
        try{
            fr = new FileReader("a/ab/abc.txt");
            fw = new FileWriter("a/ab/abcd.txt");
            // 为了提高效率，创建缓冲用的字符数组。
            char[] buffer = new char[1024];
            // 边读边写
            while ((len = fr.read(buffer)) != -1)
                fw.write(buffer, 0, len);
        }catch (IOException e){  // FileNotFoundException是IOException的子类
            System.out.println("mmm");
            e.printStackTrace();
        }finally {
            try {
                if (fw != null) fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (fr != null) fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        testFileReaderWriterCopy();
    }
}
