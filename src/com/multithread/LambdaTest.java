package com.multithread;

public class LambdaTest {
    public static void main(String[] args) {
        // statement lambda can be replaced with expression lambda
        LearnLambda1 learnLambda1 = () -> System.out.println("learnLambda1");  // 无参数的

        LearnLambda2 learnLambda2 = (int a) -> System.out.println(a+1);  // 一个参数的
        LearnLambda2 ll2 = a -> System.out.println(a);  // 可以省略 括号 类型

        LearnLambda3 ll3 = (int a, int b) ->  a+b;
        System.out.println( ll3 instanceof LearnLambda3 );
        System.out.println( ll3.whatever(1, 2) );
    }
}

interface LearnLambda1{
    void learn();
}

interface LearnLambda2{
    void learn(int a);
}
interface LearnLambda3{
    int whatever(int a, int b);
}
