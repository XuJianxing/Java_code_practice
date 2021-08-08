package com.collection;


// 测试泛型
public class TestGeneric {
    public static void main(String[] args){
        TestCollection tc = new TestCollection();
        tc.set("a", 0);
        tc.set(1, 1);
        int a = (Integer) tc.get(1);

        TestCollection2<String> tc2 = new TestCollection2<>();
        tc2.set("a", 0);
        String b = tc2.get(0);

    }
}

class TestCollection{
    Object[] objs = new Object[5];

    public void set(Object obj, int index){
        objs[index] = obj;
    }
    public Object get(int index){
        return objs[index];
    }

}
// <E> 代表之后声明时传入的类型
class TestCollection2<E>{
    Object[] objs = new Object[5];

    public void set(E e, int index){
        objs[index] = e;
    }
    public E get(int index){
        return (E)objs[index];
    }

}
