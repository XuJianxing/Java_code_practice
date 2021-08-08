package com.collection;

import java.util.Collection;  // 接口
import java.util.List;        // 接口
import java.util.ArrayList;   // 实现类 <泛型>

import java.util.Arrays;


public class TestList {
    public static void main(String[] args){
        /*
        容器接口层次结构：
        <<interface>> Collection -> <<interface>> Set -> HashSet    // 无序不可重复 底层是用HashMap实现的
                                                      -> TreeSet
                                 -> <<interface>> List -> ArrayList  // 有序可重复  // 查询效率高，增删效率低，线程不安全
                                                       -> LinkedList  // 查询效率低，增删效率高
                                                       -> Vector  // 线程安全的数组
        <<interface>> Map -> HashMap
                          -> TreeMap
        */

        /* Collection接口中定义的方法
        c.add();  //添加元素
        c.remove();  // 移除元素
        c.clear();   // 清除所有元素
        c.contains(); // 是否包含某元素
        c.size()  // 长度
        c.toArray(); // 变成对象数组
        Iterator iterator()  // 获得迭代器，用于遍历所有元素
        boolean containsAll(Collection c)  // 本容器是否包含c容器中所有的元素
        boolean addAll(Collection c)  // 将容器c中所有元素增加到本容器
        boolean removeAll(Collection c)  // 移除本容器和c容器中都包含的元素
        boolean retainAll(Collection c)  // 取本容器和容器c中都包含的元素，移除非交集元素
        */
        /*
        ArrayList底层使用Object数组来存储元素数据 线程不安全
        本质上就是通过定义新的更大的数组，将旧数组中的内容拷贝到新数组，来实现扩容。
        ArrayList的Object数组初始化长度为10，如果我们存储满了这个数组，需要存储第11个对象，
        就会定义新的长度更大的数组，并将原数组内容和新的元素一起加入到新数组中
         */
        test01();
    }
    public static void test01(){
        Collection<String> c = new ArrayList<>();
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        c.add("a");
        c.add("b");
        c.add("c");
        System.out.println("c:");
        System.out.println(c);

        c.remove("b");  // 是移除而不是删除，之前建的对象还在，内存没有释放
        Object[] oc = c.toArray();
        System.out.println("oc:"+oc[1]);  // toArray之后就可以下标找了
        System.out.println(c.size());  // c已经改过了
        System.out.println(oc.toString());  // 打印的不知道什么东西
        System.out.println(Arrays.toString(oc));  // Arrays.toString()方法是把一个数组变成字符串
        c.clear();
        System.out.println(c.size());
        System.out.println(c.toArray());
    }
    public static void test02(){
        List<String> list01 = new ArrayList<>();
        list01.add("a");
        list01.add("b");
        list01.add("c");
        List<String> list02 = new ArrayList<>();
        list02.add("b");
        list02.add("c");
        list02.add("d");
        System.out.println(list01);

        list01.addAll(list02);  // 修改是对原容器进行修改
        System.out.println(list01);
        System.out.println(list01.indexOf("b"));
        System.out.println(list01.lastIndexOf("b"));

        list01.removeAll(list02);
        System.out.println(list01);

        list01.add(1,"1");
        System.out.println(list01);

        list01.set(1,"2");
        System.out.println(list01);

        list01.remove(1);
        System.out.println(list01);

    }
}
