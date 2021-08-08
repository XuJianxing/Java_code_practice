package com.collection;

import java.util.TreeMap;
import java.util.HashMap;

public class TestHashMap {
    /*
    HashMap的位桶数组，初始大小为16。实际使用时，显然大小是可变的。
    如果位桶数组中的元素达到(0.75*数组 length)， 就重新调整数组大小变为原来2倍大小。

    扩容很耗时。扩容的本质是定义新的更大的数组，并将旧数组内容挨个拷贝到新数组中。
    */
    //JDK8中，HashMap在存储一个元素时，当对应链表长度大于8时，
    // 链表就转换为红黑树，这样又大大提高了查找的效率。

    // TreeMap的put()/remove()方法大量使用了红黑树的理论。
    // TreeMap和HashMap实现了同样的接口Map，因此，用法对于调用者来说没有区别。
    // HashMap效率高于TreeMap;在需要排序的Map时才选用TreeMap。

    private Node2[] table;  // 位桶数组
    int size;       // 键值对个数

    public TestHashMap(){
        table = new Node2[16];  // 在调用构造方法时创建table数组
    }

    public void put(Object key, Object value){
        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        //newNode.next = null;

        Node2 temp = table[newNode.hash];
        if(temp == null){
            table[newNode.hash] = newNode;
        }else {

        }

    }
    public int myHash(int v, int length){
        return v & (length-1);  // 按位与运算，如果被与数是2的n次方-1 则结果等于对 被与数 取余
    }

    public static void main(String[] args){
        TestHashMap m = new TestHashMap();
        m.put(101, "aaa");
        m.put(102, "bbb");
        m.put(103, "ccc");

        System.out.println(m);
    }
}
