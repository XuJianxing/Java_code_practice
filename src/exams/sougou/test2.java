package exams.sougou;
/* 生成密码
密码生成器有N个槽位，操作M次。每次输入两个数L，R代表槽位下标。
密码生成器槽位相应位置会改为当前轮次m（从1开始）
最终密码是sum(i*a[i]) % 100000009
 */
import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    // 硬循环写法
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        //int[][] LiRi = new int[M][2];
//        int[] stacks = new int[N];
//        long code = 0L;
//        int n = 1;
//        for (int i = 0; i < M; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            //code += n * calculate(a, b);
//            for (int j = a; j <= b; j++)
//                stacks[j] = i + 1;
//        }
//        for (int i = 0; i < N; i++) {
//            code += i * stacks[i];
//        }
//        System.out.println(code%100000009);
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[] stacks = new int[N];
//        long code = 0L;
//        for (int i = 0; i < M; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            for (int j = a; j <= b; j++){
//                if (stacks[j] == 0){
//                    code += (i + 1) * j;
//                    stacks[j] = i + 1;
//                }
//                else {
//                    code += j * (i - stacks[j] + 1);
//                    stacks[j] = i + 1;
//                }
//            }
//        }
//        System.out.println(code%100000009);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] stacks = new int[N];
        long code = 0L;
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            stacks[a] = i + 1;
            stacks[b] = i + 1;
        }
        int max = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            //if (Math.max(stacks[i], max))
        }
        System.out.println(code%100000009);
    }
}
