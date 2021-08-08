package com.company;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Main{
    public static void main(String[] args) {
	// write your code here
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(0b10000000000000000000000000000000);
        System.out.println(0b01111111111111111111111111111111);

        Integer a = 200;
        Integer b = 200;
        System.out.println(a.hashCode()+"_"+b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a==200);
        System.out.println(a==b);
        double d1 = 1.99d;
        double d2 = 1.88d;
        double d3 = 1.77d;
        System.out.println(d1-d2);
        System.out.println(d2-d3);
    }

}
