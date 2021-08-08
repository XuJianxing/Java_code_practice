package com.xjx1;

//内部类
class Outer{
    public int age = 10;
    public void show(){
        System.out.println("outer age:"+age);
    }

    class Inner{
        public int age = 20;
        public void show(){
            System.out.println("outer age:"+Outer.this.age);
            System.out.println("Inner age:"+this.age);
            System.out.println(Outer.this.age==this.age);
            System.out.println("age"+age);
            int age = 30;
            System.out.println("Inner age:"+this.age);
            System.out.println("age"+age);
        }
    }
    Inner inn = new Inner();
}

// 静态内部类
class OuterTest{
    static class StaticInner{

    }
}

//匿名内部类
//适合那种只需要使用一次的类；就是在调用时直接在传参部分直接new一个类和相应的方法
interface AnonymousInterface{
    void aif();
}
class AnonymousClass{
    void ac(){

    }
}
// 局部内部类
//略

public class TestOuterInner {

    public static void testanonymous(AnonymousInterface ac){
        System.out.println(ac.toString());
        ac.aif();
    }
    public static void testanonymouscalss(AnonymousClass ac){
        System.out.println(ac.toString());
        ac.ac();
    }

    public static void main(String[] args){
        Outer out = new Outer();
        out.show();

        Outer.Inner in = new Outer().new Inner();
        Outer.Inner in2 = out.new Inner();
        System.out.println("in.age:"+in.age);
        System.out.println("in2.age:"+in2.age);
        in.show();

        // 因为静态内部类就是类内部的静态成员，所以可以直接用类名访问
        OuterTest.StaticInner ssi = new OuterTest.StaticInner();
        // 测试匿名内部类
        // 在调用方法时直接传入一个new类
        testanonymous(new AnonymousInterface() {
            @Override
            public void aif() {
                System.out.println(this.toString());
            }
        });
        testanonymouscalss(new AnonymousClass(){
            public void ac(){
                System.out.println("ac");
            }
        });

    }
}
