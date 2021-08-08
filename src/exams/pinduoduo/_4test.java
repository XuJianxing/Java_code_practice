package exams.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class _4test {
}

// 搭积木
//有N个长方体积木， 每个积木的高都是1，长宽都为Li，重量为Wi。
// 现在想要用这些积木搭一个高高的金字塔，每一层由且仅由一块积木组成，
// 同时每一层积木的边长都比下方的积木小，每块积木智能承受自身重量的7倍重量，
// 请计算最高可以搭一个多高的金字塔？

 class E4 {
    static class Box {
        int len;
        int weight;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            Box[] b = new Box[n+1];
            b[0] = new Box();
            for(int i = 1; i < n+1; ++i) {
                b[i] = new Box();
                b[i].len = in.nextInt();
            }
            for(int i = 1; i < n+1; ++i) {
                b[i].weight = in.nextInt();
            }
            Arrays.sort(b, (b1, b2) -> {return b1.len == b2.len ? b1.weight-b2.weight : b1.len - b2.len;});
            int res = 0;
            int[][] dp = new int[n+1][n+1];
            for(int i = 0; i < n+1; ++i) {
                for(int j = 0; j < n+1; ++j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            for(int i = 1; i < n+1; ++i) {
                for(int k = 0; k < i; ++k) {
                    if(b[k].len < b[i].len) {
                        for(int j = 0; j <= k; ++j) {
                            if(dp[k][j] != Integer.MAX_VALUE && dp[k][j] <= b[i].weight*7) {
                                dp[i][j+1] = Math.min(dp[i][j+1], dp[k][j]+b[i].weight);
                                res = Math.max(res, j+1);
                            }
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}