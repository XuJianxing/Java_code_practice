package com.xjx1;
import java.util.Arrays;

public class TestSort {
    public static void main(String[] args){
        int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
        bubbleSort(values);
        System.out.println(Arrays.toString(values));

    }

    public static void bubbleSort(int[] values) {
        int temp;
        for (int i = 0; i < values.length; i++) {
            boolean noexchange = true;
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    noexchange = false;
                }
            }
            if (noexchange){
                break;
            }
        }
    }

}
