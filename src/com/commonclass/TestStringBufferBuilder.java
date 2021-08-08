package com.commonclass;

public class TestStringBufferBuilder {
    // buffer比builder早出现
    //  1. StringBuffer JDK1.0版本提供的类，线程安全，做线程同步检查， 效率较低。
    //  2. StringBuilder JDK1.5版本提供的类，线程不安全，不做线程同步检查，因此效率较高。 建议采用该类。
    public static void main(String[] args){
        StringBuilder strbuilder = new StringBuilder("m");
        for (int i=0;i<2;++i){
            System.out.print(i);
            strbuilder.append(i);
        }
        System.out.println("--");
        System.out.println(strbuilder);
        strbuilder.reverse();            // 对原str做改动
        System.out.println(strbuilder);
        strbuilder.setCharAt(1, '!');
        System.out.println(strbuilder);
        strbuilder.insert(1,"zxc");
        System.out.println(strbuilder);

        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println(num4+"_"+time4);
    }
}
