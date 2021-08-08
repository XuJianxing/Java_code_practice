package foroffer.offer;
/* n 个骰子的点数概率
动态规划
使用一个二维数组 dp 存储点数出现的次数，其中 dp[i][j] 表示前 i 个骰子产生点数 j 的次数。
次数除以总数就是概率
 */
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _60dicesSum {
    // 递归：定义一个6n-n+1的数组，和为s的点数出现的次数保存到数组第s-n个元素里。
    private int g_maxValue = 6;
    public void printProbability(int number){
        if (number < 1) return;
        int maxSum = number * g_maxValue;
        int[] probabilities = new int[maxSum - number + 1];
        for (int i = number; i <= maxSum; i++)
            probabilities[i - number] = 0;
        probability(number, probabilities);
        int total = (int)Math.pow(g_maxValue, number);
        for (int i = number; i <= maxSum; i++) {
            double ratio = (double)probabilities[i - number] / total;
            System.out.printf("%d: %e\n", i, ratio);
        }
    }
    private void probability(int number, int[] probabilities){
        for (int i = 1; i <= g_maxValue; i++)
            probability(number, number, i, probabilities);
    }
    private void probability(int original, int current, int sum, int[] probabilities){
        if (current == 1) probabilities[sum - original]++;
        else
            for (int i = 0; i<= g_maxValue; i++)
                probability(original, current - 1, i + sum, probabilities);
    }
    // 循环：用两个数组存储骰子点数的每个总数出现的次数。
    public void printProbability_2(int number){
        if (number < 1) return;
        int[][] probabilities = new int[2][g_maxValue * number + 1];
        int flag = 0;
        for (int i = 1; i <= g_maxValue; i++)
            probabilities[flag][i] = 1;
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++)
                probabilities[1 - flag][i] = 0;
            for (int i = k; i <= g_maxValue * k; i++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; j++)
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = number; i <= g_maxValue * number; i++) {
            double ratio = (double)probabilities[flag][i] / total;
            System.out.printf("%d: %e\n", i, ratio);
        }
    }
    //cyc: dp:
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
                for (int k = 1; k <= face && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));

        return ret;
    }
    // cyc: dp + 旋转数组
    public List<Map.Entry<Integer, Double>> dicesSum2(int n) {
        final int face = 6;
        final int pointNum = face * n;
        long[][] dp = new long[2][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[0][i] = 1;

        int flag = 1;                                     /* 旋转标记 */
        for (int i = 2; i <= n; i++, flag = 1 - flag) {
            for (int j = 0; j <= pointNum; j++)
                dp[flag][j] = 0;                          /* 旋转数组清零 */

            for (int j = i; j <= pointNum; j++)
                for (int k = 1; k <= face && k <= j; k++)
                    dp[flag][j] += dp[1 - flag][j - k];
        }

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[1 - flag][i] / totalNum));

        return ret;
    }
}
