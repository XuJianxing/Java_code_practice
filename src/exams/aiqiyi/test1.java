package exams.aiqiyi;
/* 谁当裁判
假设有N个人要玩游戏，每轮游戏必须选出一个人当裁判，剩下的N-1个人作为玩家。
现在第i个人要求作为玩家进行至少Ai轮游戏，那么至少需要进行多少轮游戏才能满足所有人的要求？
 */
/* 做法：
先求出数组的sum()，求出最大的a[i]设为max，那么玩的局数至少是max，max * (n-1)就是玩max局数的总人数。
如果它大于sum，则玩max局就能所有人玩完。
否则，找出某个局数x，使得x * (n-1) >= sum，因为sum比较大，所以先排序再二分搜索。
二分的下界是max,上界是sum
 */
import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] AN = new int[N+1];
        AN[0] = -1;
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            AN[i] = scanner.nextInt();
            sum += AN[i];
        }
        Arrays.sort(AN);
        long result = AN[N];
        if (sum <= AN[N] * (N-1)){
            System.out.println(AN[N]);
        }
        else {
            long r = sum;
            while (result < r){
                long mid = (result + r) / 2;
                if (mid * (N-1) >= sum) r = mid;
                else result = mid + 1;
            }
            System.out.println(result);
        }
    }
}
