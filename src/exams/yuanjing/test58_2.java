package exams.yuanjing;
/*
找出字符串中的重叠子串，计算各个字母对应的重叠子串的长度之和，并按照出现次数从大到小进行输出。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class test58_2 {
    // 先把字符放到hashset里使不重复，然后对每个字符判断并计算子串长度，
    // 每个字符对应的子串的长度用counts数组存储；
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  // aaabcccaddfffaa
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
            hs.add(str.charAt(i));  // HashSet使字符不重复
        char[] chars = new char[hs.size()];
        int _i=0;
        for (char ch:hs)
            chars[_i++] = ch;  // 字符放到数组里，这样可以索引遍历
        int[] counts = new int[chars.length];  // 记录相应字符的子串总长度
        for (int i = 0; i < chars.length; i++) {
            boolean flag = false;  // 要判断如何计算子串长度 +1还是+2
            for (int j = 0; j < str.length()-1; j++) {
                if (str.charAt(j) == chars[i] && str.charAt(j) == str.charAt(j+1)){
                    if (flag) counts[i] += 1;
                    else {
                        counts[i] += 2;
                        flag = true;
                    }
                }
                else flag = false;  // 说明子串结束了
            }
        }
        bSort(counts, chars);
        System.out.println(Arrays.toString(counts));
        System.out.println(Arrays.toString(chars));
    }
    // 改后的冒泡，为了同时排两个数组
    static void bSort (int[] arr, char[] chars) {
        int i, j;
        for (i=1; i<arr.length; i++) /* 外循环为排序趟数，len个数进行len-1趟 */
            for (j=0; j<arr.length-i; j++) { /* 内循环为每趟比较的次数，第i趟比较len-i次 */
                if (arr[j] < arr[j+1]) { /* 相邻元素比较，若逆序则交换（升序为左大于右，降序反之） */
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    char tempchar = chars[j];
                    chars[j] = chars[j+1];
                    chars[j+1] = tempchar;
                }
            }
    }
    // 原始的冒泡排序
    static void bubbleSort (int[] arr) {
        int i, j;
        for (i=1; i<arr.length; i++) /* 外循环为排序趟数，len个数进行len-1趟 */
            for (j=0; j<arr.length-i; j++) { /* 内循环为每趟比较的次数，第i趟比较len-i次 */
                if (arr[j] > arr[j+1]) { /* 相邻元素比较，若逆序则交换（升序为左大于右，降序反之） */
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
    }

}
