package exams._360;

import java.util.Scanner;

public class Main {
    /*
    // 题1
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length = s.length();
        int max = 0;
        // 按子串长度遍历，再滑动窗口遍历字符串判断求计数count
        for (int i=1;i<=length;i++){  // 控制子串长度
            for (int j=0;j<=length-i;j++){  // 从左到右第j个子串

                int count = 0;
                for (int k=0;k<=length-i;k++)  // 从左到右滑动
                    if (s.substring(j,j+i).equals(s.substring(k,k+i)))
                        count++;
                max = Math.max(max,count);
            }
        }
        System.out.println(max);
    }
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int N = Integer.valueOf(ss[0]);
        int M = Integer.valueOf(ss[1]);
        int[] nums = new int[M];
        for (int i=0;i<M;i++)
            nums[i] = sc.nextInt();
        int count = N;
        for (int i=0;i<N;i++){
            for (int j=0;j<M-1;j++){
                if (nums[j] > i && nums[j] > N-i-1)
                    count--;
            }
        }
        System.out.println(count);
    }
}
