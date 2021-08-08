package exams._58;
/*
n条鱼，每条F值>0。每一轮F最小的被次小的吃掉，吃后F值相加。
求m轮后最小值
16 5 9 8 10 23 7 4 12 5 8 3 2 11 1 3 6 12
7 5 2 2 2 2 2 3 4
 */
import java.util.Arrays;
import java.util.Scanner;
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] fs = new int[n];
        for (int i = 0; i < n; i++) {
            fs[i] = sc.nextInt();
        }
        Arrays.sort(fs);
        //System.out.println(Arrays.toString(fs));
        for (int i = 0; i < m; i++) {
            if (fs[i] != fs[i+1]){
                fs[i+1] += fs[i];
            }else {
                int t = i + 1;
                while (fs[i] == fs[t]) t++;
                fs[t] += fs[i];
            }
            Arrays.sort(fs, i+1, fs.length);
        }
        System.out.println(fs[m]);
    }
}
