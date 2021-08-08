package exams.pinduoduo;
/*
珍珠项链最短移动距离
 */
import java.util.Scanner;


//public class Main {
public class _test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        int[] nlist = new int[N];
        for(int i = 0; i < N; i++){
            nlist[i] = sc.nextInt();
        }
        int min=0;  // 最小步数
        for(int i=0;i<N;i++)
            min += nlist[i];
        System.out.println("min"+min);
        int middle_index = L/2;  // 中间索引
        for(int i=0;i<L;i++){
            int sum = 0;
            int j=0;
            for (j=0;j<N;j++){  // 挨个求步数
                sum += Math.abs(Math.min(nlist[j]-i, Math.abs(nlist[j]-i-L)));
            }

            if (sum<=min) {
                min = sum;
                middle_index = j;
            }
            int count = 0;
            for (int k=0;k<N;k++){
                //if (nlist[k])
            }
            System.out.println("sum"+sum);
        }
        System.out.println(min);
    }
}