package exams.yuanjing;
/* 最大光伏面板群
光伏电站由多块光伏面板构成，假设光伏面板是正方形。
现给定一块场地用二维矩阵表示，用1代表此坐标装了一块光伏面板，0代表未安装
如果两块面板的任意一边相互接壤，则认为是同一块面板群。
问给定场地里有最大光伏面板群包含了多少块光伏面板。
输入一行逗号区分 M行N列，然后M行
 */
import java.util.Scanner;

public class test2 {
    private static int[][] nexts={{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(",");
        int M = Integer.valueOf(in[0]);
        int N = Integer.valueOf(in[1]);
        int[][] states = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] _ts = sc.nextLine().split(",");
            for (int j = 0; j < N; j++)
                states[i][j] = Integer.valueOf(_ts[j]);
        }
        System.out.println(maxOut(states, M, N));
    }
    private static int maxOut(int[][] states, int M, int N) {
        if(states==null||states.length==0) return 0;
        int maxPlates = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                maxPlates = Math.max(maxPlates,DFS(states, i, j, M, N));
            }
        return maxPlates;
    }
    private static int DFS(int[][] states,int i,int j, int M, int N) {
        if(i<0 || i>=N || j<0 || j>=M || states[i][j]==0)
            return 0;
        int areas = 1;
        states[i][j]=0;
        areas += DFS(states, i+1, j, M, N);
        areas += DFS(states, i-1, j, M, N);
        areas += DFS(states, i, j+1, M, N);
        areas += DFS(states, i, j-1, M, N);
        return areas;
    }
}
