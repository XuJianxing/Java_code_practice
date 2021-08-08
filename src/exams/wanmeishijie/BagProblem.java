package exams.wanmeishijie;
import java.util.Scanner;

public class BagProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++)
            weights[i] = scanner.nextInt();
        for (int i = 0; i < N; i++)
            values[i] = scanner.nextInt();
        System.out.println(bag(W, N, weights, values));
    }

    /**
     *
     * @param W 背包总体积
     * @param N 物品数量
     * @param weights 数组，存储N个物品的重量
     * @param values 数组，存储N个物品的价值
     * @return 最大价值
     */
    private static int bag(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }
}
