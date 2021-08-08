package foroffer.leetcode;

public class ClimbStairs {
    /*
    https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
    爬楼梯讲解
    */
    public int climbStairs(int n) {
        // 动态规划法：
        // 到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和
        // 也就是，最后一步总是1步或2步，
        // 用数组存储1~n的个数: dp[i]=dp[i−1]+dp[i−2]
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];  // 改成斐波那契数列的规律就是不用数组存，每次更新
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 递归法但是用数组存了计算结果。所以减少了计算量。
    static int count = 0;
    static public int[] climbStairs2(int n) {
        int[] r = {0,0};
        if(n==1){ return r;}
        if(n==2){ return r;}
        count++;
        r[1] = count;
        r[0]=climbStairs2(n-1)[0]+climbStairs2(n-2)[0];
        return r;
    }
}
