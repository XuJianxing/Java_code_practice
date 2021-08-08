package exams.wangyi;
/* 逆序对的距离和

 */
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int result = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) result += j - i;
            }
        }
        System.out.println(result);
    }
}
