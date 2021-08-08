package exams.wangyi;
/* 完美的最长子序列
先求出每个位置的前面所有数字和。序列长度应该n-1，最后一个求和不包含自己
 */
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0){
            T--;
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = in.nextInt();
            int[] sums = new int[n];
            sums[0] = nums[0];
            for (int i = 1; i < n; i++)
                sums[i] = sums[i-1] + nums[i];
            int max_length = 0, result = 0;
            int sum = sums[0];
            int now_sum = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] >= now_sum){
                    max_length++;
                    now_sum += nums[i];
                    result = Math.max(result, max_length);
                }
                else{
                    now_sum = 0;
                    sum = sums[i];
                    max_length = 0;
                }
            }
            System.out.println(result);
        }
    }
}
