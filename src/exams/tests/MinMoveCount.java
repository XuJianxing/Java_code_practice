package exams.tests;
/* 小米2
移动最少次数，使得数组元素前后差值绝对值最小
 */
import java.util.Arrays;
import java.util.Scanner;

public class MinMoveCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0;i<len;i++){
            nums[i]=sc.nextInt();
        }

        int[] numssort=nums.clone();
        Arrays.sort(numssort);
        int[] sort2 = new int[numssort.length];
        for (int i = 0; i < numssort.length; i++) {
            sort2[i] = numssort[numssort.length - i - 1];
        }
        int count=0;
        int count2=0;
        for(int j = 0;j<len;j++){
            if(nums[j]!=numssort[j])
                count++;
            if (nums[j]!=sort2[j])
                count2++;
        }
        System.out.println(Math.min(count, count2));
    }

}
