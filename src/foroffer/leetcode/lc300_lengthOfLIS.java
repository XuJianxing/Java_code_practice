package foroffer.leetcode;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 */
public class lc300_lengthOfLIS {
    /**
     * 动态规划
     * 状态定义：dp[i] 的值代表 nums 前 i 个数字的最长子序列长度。
     * 转移方程：设j属于[0, i)，考虑每轮计算新dp[i]时，遍历列表[0, i)区间，做以下判断：
     *     1. 当nums[i] > nums[j]时，nums[i]可以接在nums[j]后面，则这时候最长上升子序列为dp[j] + 1
     *     对于上述所有的j，求出dp[j]+1的最大值，就是dp[i]
     *     遍历直到i结尾
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i])
                    // 状态转移方程
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // 每次算出dp[i]之后，取较大值为结果
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 优化，二分法降低时间复杂度
     */
    public int lengthOfLIS_2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

}
