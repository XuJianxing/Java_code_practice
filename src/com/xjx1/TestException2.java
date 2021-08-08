package com.xjx1;

/**IllegalAgeException：非法年龄异常，继承Exception类*/
class IllegalAgeException extends Exception {
    //默认构造器
    public IllegalAgeException() {

    }
    //带有详细信息的构造器，信息存储在message中
    public IllegalAgeException(String message) {
        super(message);
    }
}
class Person2 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age < 0) {
            throw new IllegalAgeException("人的年龄不应该为负数");
        }
        this.age = age;
    }

    public String toString() {
        return "name is " + name + " and age is " + age;
    }
}

public class TestException2 {
    public static void main(String[] args) {
        Person2 p = new Person2();
        try {
            p.setName("Lincoln");
            p.setAge(-1);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println(p);
    }
}
