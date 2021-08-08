package com.commonclass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TestFile {
    public static void main(String[] args){
        System.out.println(System.getProperty("user.dir"));  // 本项目的目录

        File f = new File("a.txt");  // new对象的时候必须传入一个文件名才能创建对象
        boolean e = f.exists();  // 判断file是否存在
        e = f.isDirectory();     // 判断file是否目录
        e = f.isFile();          // 是不是file
        long m = f.lastModified();  // 最后修改时间
        System.out.println("lastModified: "+m);
        System.out.println(new SimpleDateFormat().format(new Date(m)));
        long l = f.length();     // 文件大小
        System.out.println("length: "+l);
        System.out.println("getName: "+f.getName());
        System.out.println("getPath: "+f.getPath());
        System.out.println(f.getAbsolutePath());
        try {
            f.createNewFile();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        File f2 = new File("d:/b.txt");//绝对路径
        try {
            f2.createNewFile();
        }catch (IOException ioe){
            ioe.getMessage();
        }

        f.delete();
        File mkdir = new File("mkdir");  // 默认从当前项目目录开始创建目录
        System.out.println(mkdir.mkdir());
        File mkds = new File("a/b");
        System.out.println(mkds.mkdirs());
        System.out.println(mkds.getParentFile());
    }
}
