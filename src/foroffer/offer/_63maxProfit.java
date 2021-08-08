package foroffer.offer;
/* 股票一次买卖的最大利润
 */
public class _63maxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);  // 是当前值减最小值
        }
        return maxProfit;
    }
}
