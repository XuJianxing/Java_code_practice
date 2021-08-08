package com.collection;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args){
        Map<Integer, String> tm = new TreeMap<>();
        tm.put(20, "b");
        tm.put(10, "a");
        tm.put(30, "c");
        System.out.println(tm);
        for (Integer key:tm.keySet())
            System.out.println(key+"="+tm.get(key));

        Map<Emp, String> tm2 = new TreeMap<>();
        tm2.put(new Emp(100, "aa", 50000),"a+a+a");
        tm2.put(new Emp(200, "bb", 40000),"b+b+b");
        tm2.put(new Emp(300, "cc", 30000),"c+c+c");
        tm2.put(new Emp(400, "cc", 40000),"d+d+d");
        System.out.println(tm2);

    }
}


class Emp implements Comparable<Emp>{
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Emp o) {
        if (this.salary > o.salary)
            return 1;
        else if (this.salary < o.salary)
            return -1;
        else
            return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString(){
        // 重写以后把原先Emp对象toString时候输出的hashcode改为想要输出的内容
        return "id:"+id+",name:"+name+",salary"+salary;
    }

}

