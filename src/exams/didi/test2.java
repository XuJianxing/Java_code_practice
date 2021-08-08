package exams.didi;
/*
给出一个长度为n的数组a，你需要在这个数组中找到一个长度至少为m的区间，
使得这个区间内的数字的和尽可能小。
 */
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();int m = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            min = sum(array, m);
            for (int j = 0; j < n-m; j++) {
                min = Math.min(min, min-array[j]+array[m+j]);
            }
        }
        System.out.println(min);
    }
    private static int sum(int[] array,int end){
        int sum = 0;
        for (int i = 0; i < end; i++)
            sum += array[i];
        return sum;
    }
}
