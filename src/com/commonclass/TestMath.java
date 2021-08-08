package com.commonclass;
/*
Math类在lang包中，自动导入，常用方法：
abs 绝对值
acos,asin,atan,cos,sin,tan 三角函数
sqrt 平方根
pow(double a, double b) a的b次幂
max(double a, double b) 取大值
min(double a, double b) 取小值
ceil(double a) 大于a的最小整数
floor(double a) 小于a的最大整数
random() 返回 0.0 到 1.0 的随机数
long round(double a) double型的数据a转换为long型(四舍五入)
toDegrees(double angrad) 弧度->角度
toRadians(double angdeg) 角度->弧度
*/
import java.util.Random;

public class TestMath {
    public static void main(String[] args) {
        //取整相关操作
        System.out.println(Math.ceil(3.2));
        System.out.println(Math.floor(3.2));
        System.out.println(Math.round(3.2));  // 四舍五入取整
        System.out.println(Math.round(3.8));
        //绝对值、开方、a的b次幂等操作
        System.out.println(Math.abs(-45));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.pow(5, 2));
        System.out.println(Math.pow(2, 5));
        //Math类中常用的常量
        System.out.println(Math.PI);
        System.out.println(Math.E);
        //随机数
        System.out.println(Math.random());  // 生成 [0,1) 之间的数

        Random rand = new Random();  // new一个Random对象之后再做操作
        //随机生成[0,1)之间的double类型的数据
        System.out.println(rand.nextDouble());
        //随机生成int类型允许范围之内的整型数据
        System.out.println(rand.nextInt());
        //随机生成[0,1)之间的float类型的数据
        System.out.println(rand.nextFloat());
        //随机生成false或者true
        System.out.println(rand.nextBoolean());
        //随机生成[0,10)之间的int类型的数据
        System.out.print(rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据
        System.out.print(20 + rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据（此种方法计算较为复杂）
        System.out.print(20 + (int) (rand.nextDouble() * 10));
    }
}
