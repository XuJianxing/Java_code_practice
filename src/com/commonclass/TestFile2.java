package com.commonclass;

import java.io.File;
import java.util.Arrays;

public class TestFile2 {
    public static void main(String[] args) {
        File f = new File("a");
        // 列出来的地址列表是根据创建对象时传入的地址的相对路径
        System.out.println(Arrays.toString(f.listFiles()));
        printFile(f, 0);
    }

    static void printFile(File file, int level) {
        //输出层次数
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        //输出文件名
        System.out.println(file.getName());
        //如果file是目录，则获取子文件列表，并对每个子文件进行相同的操作
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                //递归调用该方法：注意等+1
                printFile(temp, level + 1);
            }
        }
    }

}
