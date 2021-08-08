package exams.mgeeker;
// 数字矩阵乘积最大
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nxm = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nxm[i][j] = sc.nextInt();
            }
        }

        if (n==1||m==1) System.out.println(nxm[0][0]);
        else {
            int ans = nxm[0][0] * nxm[1][1], a, b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a = nxm[i][j];
                    for (int k = 0; k < n; k++) {
                        for (int h = 0; h < m; h++) {
                            if (i == k || j == h) continue;
                            b = a * nxm[k][h];
                            if (b >= ans) ans = b;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}