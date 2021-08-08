package exams.xiaohongshu;
/*
有阻挡的棋盘上，从左上角开始走，走到右下角，可以上下左右走，走的最短步数是多少
 */
import java.util.Scanner;
import java.util.ArrayList;

public class test1 {
    static ArrayList<Integer> stepCounts = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] block = new int[k][2];
        for (int i=0;i<k;i++)
            for (int j=0;j<2;j++)
                block[i][j] = sc.nextInt();
        countPath(n,m,k,block);
    }
    public static void countPath(int n, int m, int k, int[][] block){
        int[][] net = new int[n][m];
        for (int i=0;i<k;i++)
            net[block[i][0]][block[i][1]] = 1;
        dfs(net, new boolean[n][m], 0, 0, 0, n, m);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<stepCounts.size();i++)
            min = Math.min(min, stepCounts.get(i));
        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
    public static void dfs(int[][] dp, boolean[][] mkd, int i, int j, int path, int n, int m){
        if (i==n-1&&j==m-1){
            stepCounts.add(path);
            return;
        }
        if (i<0 || i>=n || j<0 || j>= m ||dp[i][j] == 1 ||mkd[i][j])
            return;
        mkd[i][j] = true;
        dfs(dp,mkd,i+1,j,path+1,n,m);
        dfs(dp,mkd,i-1,j,path+1,n,m);
        dfs(dp,mkd,i,j+1,path+1,n,m);
        dfs(dp,mkd,i,j-1,path+1,n,m);
        mkd[i][j] = false;
    }

}
