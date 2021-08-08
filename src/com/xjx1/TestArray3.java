package com.xjx1;

// 测试多维数组

import java.util.Arrays;

public class TestArray3 {
    public static void main(String[] args){
        // 声明：
        int[][] a;
        int b[][];
        int c[][] = new int[3][5];  //加初始化
        System.out.println(Arrays.toString(c));  // c是hashcode
        System.out.println("------");
        c[0] = new int[2];
        c[1] = new int[3];
        c[2] = new int[]{1,2,3};  // 动态初始化
        System.out.println(Arrays.toString(c));
        // 静态初始化：
        int[][] d = { { 1, 2, 3 }, { 3, 4 }, { 3, 5, 6, 7 } };
        System.out.println(d[2][3]+"_"+d[2]+"_"+d);  //除了确切的下标指示的值以外，数组都是存的引用地址
        d[1][1] = 5;
        // 数组长度
        System.out.println(c.length);
        System.out.println(d.length);
        System.out.println(d[1].length);

        // 数组存储表格数据
        Object [] a1 = {1001, "a", 1, "aa"};
        Object [] a2 = {1002, "b", 2, "bb"};
        Object [] a3 = {1003, "c", 3, "cc"};

        Object[][] table = new Object[3][];  // Object数组
        table[0] = a1;
        table[1] = a2;
        table[2] = a3;
        System.out.println(Arrays.toString(table[0]));
        System.out.println(Arrays.toString(table[1]));
        System.out.println(Arrays.toString(table[2]));
    }
}
