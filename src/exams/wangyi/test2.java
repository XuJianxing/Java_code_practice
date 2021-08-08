package exams.wangyi;
/* 翻倍
给两个数字A < B，系数p和q，
每次操作可以A+p或者p=p*q。至少几次操作使得A >= B
 */
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0){
            T--;
            long A = in.nextInt();
            long B = in.nextInt();
            long p = in.nextInt();
            long q = in.nextInt();
            int op_count = 0;
            while (p < B - A){
                p = op2(p,q);
                op_count += 1;
            }
            op_count++;
            System.out.println(op_count);
        }
    }
    private static long op1(long A, long p){
        return A+p;
    }
    private static long op2(long p, long q){
        return p*q;
    }
}
