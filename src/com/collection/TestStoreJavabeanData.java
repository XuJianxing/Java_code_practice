package com.collection;

import java.util.*;

public class TestStoreJavabeanData {
    // JavaBean是一种java写成的可重用组件，类必须是具体的和公开的
    public static void main(String[] args){
        User user1 = new User(1001, "aa", 10000, "2017");
        User user2 = new User(1002, "bb", 20000, "2018");
        User user3 = new User(1003, "cc", 30000, "2019");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        for (User u:list)
            System.out.println(u);
        Map<Integer, User> map = new HashMap<>();
        map.put(1001, user1);
        map.put(1002, user2);
        map.put(1003, user3);
        Set<Integer> keyset = map.keySet();
        for (Integer key:keyset)
            System.out.println(key+"-"+map.get(key));
    }
}

class User{
    private int id;
    private String name;
    private double salary;
    private String hiredate;

    // 一个完整的JavaBean，要有set和get方法，以及无参构造器
    public User(){
    }

    public User(int id, String name, double salary, String hiredate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }
}