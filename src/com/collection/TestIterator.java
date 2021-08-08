package com.collection;

import java.util.*;


public class TestIterator {
    public static void main(String[] args){
        testIteratorList();
    }

    static void testIteratorList(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<5;i++)
            list.add("a"+i);
        System.out.println(list);

        // Iterator是一个接口，ArrayList类里实现了相应方法
        for (Iterator<String> iter = list.iterator();iter.hasNext();){
            // for循环里，给了初值，给了布尔表达式，没写明给迭代因子。还是正常的for循环的使用，
            // 在循环时.next()方法迭代
            String temp = iter.next();
            System.out.print(temp+"\t");
            if (temp.endsWith("3"))
                iter.remove();  // 如果需要遍历的时候删除的时候，要用迭代器遍历
        }
        // 迭代器用法2：
        Iterator<String> iter = list.iterator();
        System.out.println();
        System.out.print("while method: ");
        while (iter.hasNext()){
            String temp = iter.next();
            System.out.print(temp+"\t");
        }
        // 增强for循环遍历：foreach可以遍历list set
        System.out.println();
        System.out.print("foreach method: ");
        for (String s:list)
            System.out.print(s+"\t");
    }

    static void testIteratorMap1(){
        Map<Integer, String> map = new HashMap<>();
        map.put(100, "aaa");
        map.put(200, "bbb");
        map.put(300, "ccc");
        // Map里貌似没有实现iterator相应方法，
        // 要先在Map里调相应方法返回一个Set类型的集合对象，然后用此对象调用iterator方法
        // 这样做在for循环里相当于有了初值，而且有布尔表达式hasNet()，而且有迭代因子next
        Set<Map.Entry<Integer,String>> entryset = map.entrySet();  // 返回所有entry节点集set
        Set keyset = map.keySet();
        Collection values = map.values();

        // 因为map里每个元素是Map.Entry类型的，所以迭代器Iterator类里的泛型是传入Map.Entry
        // map.entrySet()返回一个Set对象，Set对象包含.iterator()方法，
        // .iterator()方法返回一个Iterator对象，此对象包含.hasNext()和.next()方法，可以用来迭代
        for (Iterator<Map.Entry<Integer, String>> entryIterator = entryset.iterator();entryIterator.hasNext();){
            // .next()方法返回一个声明Iterator时传入的泛型<>类型的值
            Map.Entry<Integer, String> me = entryIterator.next();
            System.out.println(me.getKey() + "--" + me.getValue());  // 打印结果不是按key顺序打印的，可能是按hash之后的顺序？
        }
    }

    static void testIteratorMap2(){
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "aa");
        map.put(20, "bb");
        map.put(30, "cc");
        Set<Integer> set = map.keySet();  // 用key的集合找到key和value来遍历
        for (Iterator<Integer> iter = set.iterator();iter.hasNext();){
            Integer key = iter.next();
            System.out.println(key+"--"+map.get(key));
        }
    }

    static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        for(int i=0;i<15;i++)
            set.add("a"+i);
        // 打印出来也不是按顺序的，估计也是按hash后的存储顺序；因为HashSet底层也是用HashMap实现的
        System.out.println(set);
        for (Iterator<String> iter = set.iterator();iter.hasNext();){
            // for循环里先声明一个迭代对象，初始化为要迭代的对象的“.iterator”方法；
            // 然后分号，后面接一个迭代对象的“.hasNext()”方法
            String temp = iter.next();  // for循环里每次iter.next()找到下一个元素
            System.out.print(temp+"\t");
        }
        System.out.println();
    }

}
