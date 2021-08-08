package com.xjx1;

import com.commonclass.TestFatherClass;
// 测试封装

public class TestEncapsulation {
    TestFatherClass tfc = new TestFatherClass();
    TestSonClass tsc = new TestSonClass();
    int e = tsc.sonabc;


}

class TestSonClass extends TestFatherClass{
    int sonabc = super.testfatherint;
    // String sonname = super.name;  default 的不能继承
    void p(){
        System.out.println(sonabc);
    }
    void print(){
        System.out.println("son print");
    }
}
