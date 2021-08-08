package exams.mgeeker;
// 做饼干
import java.util.Scanner;
import java.util.Arrays;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        int[][] n2 = new int[n][2];
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                n2[i][j] = sc.nextInt();
            }
        }
        int[] times = new int[n];
        for (int i=0;i<n;i++){
            times[i] = n2[i][1];
            if (n2[i][0]*t<times[i]) times[i]=n2[i][0]*t;
        }
        Arrays.sort(times);
        for(int i=n-1;i>=n-k;i--){
            ans += times[i];
        }
        if(ans>=l) {
            System.out.println("yes");
            System.out.println(ans);
        }
        else {
            System.out.println("no");
            System.out.println(ans);
        }
    }
}
