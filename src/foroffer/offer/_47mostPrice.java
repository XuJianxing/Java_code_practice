package foroffer.offer;
/* 礼物的最大价值
在一个m*n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（都大于0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格，直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class _47mostPrice {
    // 动态规划，一行一行对于每个位置求到这个位置的最大值
    public int getMostPrice(int[][] prices){
        if (prices == null || prices.length <= 0 || prices[0].length <= 0) return 0;
        int[][] maxValues = new int[prices.length][prices[0].length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[0].length; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) up = maxValues[i-1][j];  // 判断大于0是避开边界0
                if (j > 0) left = maxValues[i][j-1];
                maxValues[i][j] = Math.max(left,up) + prices[i][j];
            }
        }
        return maxValues[prices.length-1][prices[0].length-1];
    }
    // 优化后的，用一维数组暂存f(i,j)最大价值
    public int getMostPrice_2(int[][] prices){
        if (prices == null || prices.length <= 0 || prices[0].length <= 0) return 0;
        int[] maxValues = new int[prices[0].length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[0].length; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) up = maxValues[j];  // 判断大于0是避开边界0
                if (j > 0) left = maxValues[j-1];
                maxValues[j] = Math.max(left,up) + prices[i][j];
            }
        }
        return maxValues[prices[0].length-1];
    }

}
