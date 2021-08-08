package com.collection;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args){
        Set<String> set = new TreeSet<>();

        // Set 不可重复
        set.add("aaa");
        set.add("bb");
        set.add("c");


        for(String m:set)
            System.out.println(m);

    }
}
