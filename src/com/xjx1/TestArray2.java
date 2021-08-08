package com.xjx1;
import java.util.Arrays;

class Man2 implements Comparable{
    int age;
    int id;
    String name;
    public Man2(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return this.name;
    }
    public int compareTo(Object o){
        Man2 man = (Man2) o;
        // o = (Man) o;
        if (this.age<man.age)
            return -1;
        if(this.age>man.age)
            return 1;
        return 0;
    }
}
public class TestArray2 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(a); // 打印数组引用的值；地址？
        System.out.println(a.toString());
        String s = Arrays.toString(a); // 打印数组元素的值；// 把数组转成字符串，包含方括号，逗号，空格
        System.out.println(s);
        System.out.println(s.charAt(1));
        System.out.println(s.length());

        int[] b = {1,2,323,23,543,12,59};
        System.out.println(Arrays.hashCode(b));
        System.out.println("二分查找"+Arrays.binarySearch(b, 323));  // 不排序做二分查找有可能会返回负值，不知为何
        Arrays.sort(b);                // 排序会修改原数组，所以要不修改要先拷贝System.arraycopy();
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.hashCode(b));  // 只要改变数组值，hashcode就会变
        // 数组填充：
        Arrays.fill(b,2, 4, 99);
        System.out.println(Arrays.toString(b));

        // 对引用类型排序（将对象按compareTo方法排序）
        Man2[] msMans = { new Man2(3, "a"), new Man2(60, "b"), new Man2(2, "c") };
        Arrays.sort(msMans);  // 不重写compareTo方法就不能sort了
        System.out.println(Arrays.toString(msMans));
        System.out.println(msMans[0]);


    }
}
