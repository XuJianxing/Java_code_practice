package com.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class TestList2<E> {
    private Object[] element;  //目测必须用Object定义，以便用泛型
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    public TestList2(){
        element = new Object[DEFAULT_CAPACITY];
        //System.arraycopy();
        ArrayList<String> als = new ArrayList<>(10);
        // 容器中所有的比较操作，都是用的equals，而不是==

    }
}
