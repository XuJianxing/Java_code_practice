package com.collection;

import java.util.Map;
import java.util.HashMap;
//import java.util.Hashtable;

public class TestMap {
    /*
    HashMap与HashTable的区别
    1. HashMap: 线程不安全，效率高。允许key或value为null。
    2. HashTable: 线程安全，效率低。不允许key或value为null。
        public class Hashtable<K,V> extends Dictionary<K,V>
        implements Map<K,V>, Cloneable, java.io.Serializable
    */
    // Map可以理解为python里的字典

    public static void main(String[] args){

        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");
        System.out.println(m1.size());
        System.out.println(m1.containsKey(1));
        System.out.println(m1.containsValue("two"));
        m1.put(3, "third"); //键重复了，则会替换旧的键值对
        Map<Integer, String> m2 = new HashMap<>();
        m2.put(1, "一");
        m2.put(2, "二");
        m2.putAll(m1);    // 把m1放到m2里
        System.out.println("m1:" + m1);
        System.out.println("m2:" + m2);

    }
}
