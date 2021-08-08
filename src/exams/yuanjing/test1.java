package exams.yuanjing;
/* 股票最大亏损
假如一个数组中存储股票在一天交易窗口各时间点的股票价格（正整数）。
允许任意次买入卖出，请提供一个算法，计算通过买卖可能导致的最大亏损。
in: 100,180,0,310,40,535,695
out: 450
 */
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] _prices = sc.nextLine().split(",");
        int[] prices = new int[_prices.length];
        for (int i = 0; i < _prices.length; i++){
            prices[i] = Integer.valueOf(_prices[i]);
        }
        int maxOut = 0;
        for(int i = 0; i < prices.length-1; i++) {
            int t = prices[i] - prices[i+1];
            if(t > 0)
                maxOut += t;
        }
        System.out.println(maxOut);
    }
}
