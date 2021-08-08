package exams.wanmeishijie;
// v1到各点的最短路径
import java.util.Scanner;

public class ShortPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] v0 = sc.nextLine().split(" ");
        int n = v0.length;
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++)
            path[0][i] = Integer.valueOf(v0[i]);
        for (int i = 1; i < n; i++) {
            String[] temp_v = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++)
                path[i][j] = Integer.valueOf(temp_v[j]);
        }
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            System.out.println();
        }
    }
    private static int distance(int[][] path, int i, int j, int temp_dis){

        return 0;
    }
}
