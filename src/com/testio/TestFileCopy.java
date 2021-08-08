package com.testio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 利用文件流实现文件的复制*/
public class TestFileCopy {
    /** 记笔记：
     * 可变参数
     * try-with-resource
     * */
    
    /**
     * 将src地址目录指向的文件内容拷贝到dec文件
     * @param src 源文件
     * @param dec 目标文件
     */
    public static void testFileCopy(String src, String dec){
        /** 为了提高效率，设置缓存数组！ （读取的字节数据会暂存放到该字节数组中）*/
        byte[] buffer = new byte[1024];
        int temp = 0;
        // try-with-resource: 最后不用finally，自动释放了
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dec, true)){
            /** 边读边写
             * temp 指的是本次读取的真实长度，temp等于-1时表示读取结束
             * read是native方法
             */
            while ((temp = fis.read(buffer)) != -1)
            /** 将缓存数组中的数据写入文件中，注意：写入的是读取的真是长度
             * 如果使用fos.write(buffer)方法，那么写入的长度将会是1024，即缓存数组的长度
             */
                fos.write(buffer, 0, temp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 将abc.txt内容拷贝到d.txt
        testFileCopy("a/ab/abc.txt", "a/b/c/d.txt");
    }
}
