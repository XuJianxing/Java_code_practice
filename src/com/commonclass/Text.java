package com.commonclass;

public class Text {
    public static void main(String[] args){
        Animal a = new Cat();
        // Cat c = new Animal();  编译报错
    }

}

class Animal{

}
class Cat extends Animal{

}
