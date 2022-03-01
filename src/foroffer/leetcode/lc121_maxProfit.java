package foroffer.leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */

public class lc121_maxProfit {
    /**
     * 思路：每天考虑一次，如果今天卖出，那么之前哪天买进才能最大利润？
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int result = 0;
        int soFarMin = prices[0];
        int length = prices.length;
        for (int price : prices) {
            soFarMin = Math.min(price, soFarMin);
            result = Math.max(price - soFarMin, result);
        }
        return result;
    }
}
