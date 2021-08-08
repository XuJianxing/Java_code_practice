package com.commonclass;

public class TestSuper {

    public static void main(String[] args){
        ChildClass child = new ChildClass();
        child.f();
        System.out.println(child.value);

    }
}

class FatherClass{
    int value;
    private String s = "abc";

    public void f(){
        value = 100;
        System.out.println("FatherClass.value="+value);
    }
}

class ChildClass extends FatherClass{
    int value = 1;

    public void f(){
        super.f();

        System.out.println(("ChildClass.value="+value));
        value = 10;
        System.out.println(value);
        System.out.println(super.value);
    }
}
