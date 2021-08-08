package com.xjx1;

public class LearnStatic {
    int id;
    String name;
    String pwd;
    static String hello = "hello";

    public static void printCompany(){
        // login();             //static方法里只能调static修饰的东西
        System.out.println(hello);
    }
    public LearnStatic(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void login(){
        printCompany();
        System.out.println(hello);
        System.out.println("login: " + name);
    }
    public static void main(String[] args){
        LearnStatic u = new LearnStatic(101, "commonclass");
        LearnStatic.printCompany();
        LearnStatic.hello = "nihao";
        LearnStatic.printCompany();
    }
}
