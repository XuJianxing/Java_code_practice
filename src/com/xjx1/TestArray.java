package com.xjx1;

class Man{
    private int age;
    private int id;
    public Man(int id,int age) {
        super();
        this.age = age;
        this.id = id;
    }
}

public class TestArray {
    int[] a;
    int b[];
    int c[]=new int[10];
    //int[] d;
    //d = new int[10];  // 会报错，不知为何
    public static void main(String[] args){
        int[] a;
        int e[];          // 先声明数组，再设长度
        e = new int[10];

        int[] g = new int[10];  // 一种声明数组和长度的方法，同时定义数组和长度
        int h[] = new int[10];

        Man man[];  // 引用类型的数组
        man = new Man[10];
        man[0] = new Man(1,2);
        Man mans = new Man(1,2);

        int i[] = {1,2,3}; // 静态初始化；也可以在声明之后挨个初始化，这叫动态初始化
        for (int index=0;index<i.length;index++){
            System.out.println(i[index]);
        }
        // for-each遍历方法;  冒号前变量一定要加变量类型; 不能修改数组值
        int _1 = 0;
        for (int index:i) {
            System.out.println("遍历i的内容:"+index);
            System.out.println("索引遍历i的内容:"+i[_1]);_1+=1;
        }

        // 数组拷贝：
        String[] s = {"a","b","c","d","e","f","g"};
        String s1[] = new String[10];
        System.arraycopy(s, 1, s1, 7, 3);
        for (int _i=0;_i<s1.length;_i++){
            System.out.print(s1[_i]+"\t");
        }
    }
}
