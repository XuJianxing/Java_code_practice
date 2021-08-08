package com.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class TestCollections {
    // Collections是一个工具类，可以对Set、List、Map进行排序、填充、查找元素的辅助方法。
    public static void main(String[] args){
        List<String> aList = new ArrayList<String>();
        for (int i = 0; i < 5; i++){
            aList.add("a" + i);
        }
        //是对原列表进行改变，不创建返回新列表，都是void方法
        Collections.shuffle(aList); // 随机排列

        Collections.reverse(aList); // 逆续

        Collections.sort(aList); // 排序

        System.out.println(Collections.binarySearch(aList, "a2"));  //二分查找

        Collections.fill(aList, "hello");
        System.out.println(aList);
    }
}
