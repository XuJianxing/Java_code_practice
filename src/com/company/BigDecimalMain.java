package com.company;

import java.math.BigDecimal;
public class BigDecimalMain {

    private void timeTable(){
        for (int i = 1; i < 10; i++) { // i是一个乘数
            for (int j = 1; j <= i; j++) { // j是另一个乘数
                //System.out.print(j + "*" + i + "=" + (i * j < 10 ? (" " + i * j) : i * j) + "  ");
                System.out.print(j + "*" + i + "=" + (i * j) + "  ");
            }
            System.out.println();
        }
    }

    static void add(double n1, double n2){}
    static int count = 1;
    static void r(){
        System.out.print("r");
        count++;
        if (count > 5) return;
        else r();
    }

    public static void main(String[] args) {
        /*
        for(x=0;x<65536;x++){
            System.out.print((char)x);
        }
        */
        BigDecimal bd = BigDecimal.valueOf(5.6);
        BigDecimalMain m = new BigDecimalMain();
        m.timeTable();
        add(1,2);
        r();
    }

}
