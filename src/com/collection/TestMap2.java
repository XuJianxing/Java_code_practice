package com.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap2 {
    /* http://www.sxt.cn/Java_jQuery_in_action/nine-hashmap-bottom.html
    HashMap 存数据过程put(key,value)
    (1) 获得key对象的hashcode
    (2) 根据hashcode计算出hash值(要求在[0, 数组长度-1]区间)
    (3) 生成Entry对象.
        Entry对象包含4部分：key对象、value对象、hash值、指向下一个Entry对象的引用
    (4) 将Entry对象放到table数组中
         如果本Entry对象对应的数组索引位置还没有放Entry对象，则直接将Entry对象存储进数组;
         如果对应索引位置已经有Entry对象，则将已有Entry对象的next指向本Entry对象，形成链表。
     JDK8中，当链表长度大于8时，链表就转换为红黑树，这样又大大提高了查找的效率。

     数据过程get(key)
     (1) 获得key的hashcode，通过hash()散列算法得到hash值，进而定位到数组的位置。
     (2) 在链表上挨个比较key对象。 调用equals()方法，将key对象和链表上所有节点的key对象进行比较，
         直到碰到返回true的节点对象为止。
     (3) 返回equals()为true的节点对象的value对象。
     */
    public static void main(String[] args){
        Employee e1 = new Employee(1001, "a", 50000);
        Employee e2 = new Employee(1002, "b", 5000);
        Employee e3 = new Employee(1003, "c", 4000);
        System.out.println(e1.hashCode());
        Map<Integer, Employee> map = new HashMap<>();

        map.put(1001, e1);
        map.put(1002, e2);
        map.put(1003, e3);

        Employee emp = map.get(1001);
        System.out.println(emp.getEname());
    }
}

class Employee {
    private int id;
    private String ename;
    private double salary;

    public Employee(int id, String ename, double salary) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}