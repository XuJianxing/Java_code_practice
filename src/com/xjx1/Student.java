package com.xjx1;

public class Student {
    int id;
    String sname;
    int age;
    Computer comp;
    void study(){
        System.out.println("I'm studying: " + comp.brand);
    }

    public static void main(String[] args){
        Student stu1 = new Student();
        stu1.sname = "name";
        Computer comp1 = new Computer();
        comp1.brand = "DELL";
        stu1.comp = comp1;
        stu1.study();
    }
}

class Computer{
    String brand;
}
