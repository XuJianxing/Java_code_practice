package exams.kuaishou;
/* 最长等差数列
一个未排序数组，其中最长等差数列的长度
 */
import java.util.Arrays;
import java.util.Scanner;
public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        int[] nums = new int[N];
        int[] results = new int[N-1];
        int count = 2, tempCount = 2;
        String[] numss = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.valueOf(numss[i]);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++)
            results[i] = nums[i+1] - nums[i];
        for (int i = 0; i < results.length-1; i++){
            if (results[i] == results[i+1]) tempCount++;
            count = Math.max(tempCount, count);
        }
        if (N < 3)
            System.out.println(N);
        else
            System.out.println(count);
    }
}
