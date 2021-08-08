package com.collection;

import java.util.Set;
import java.util.HashSet;


public class TestHashSet {
    public static void main(String[] args) {
        Set<String> s = new HashSet<String>();
        s.add("hello");
        s.add("world");
        System.out.println(s);
        s.add("hello"); //相同的元素不会被加入
        System.out.println(s);
        s.add(null);
        System.out.println(s);
        s.add(null);
        System.out.println(s);
    }
}
