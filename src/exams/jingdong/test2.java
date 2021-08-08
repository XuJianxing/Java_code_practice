package exams.jingdong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] relations = new int[2][m];
        for (int i=0;i<m;i++){
            relations[0][i] = in.nextInt();
            relations[1][i] = in.nextInt();
        }
        for (int i=0;i<m;i++){  // 交换
            if (relations[0][i] > relations[1][i]){
                int temp = relations[0][i];
                relations[0][i] = relations[1][i];
                relations[1][i] = temp;
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        Arrays.sort(relations[0]);
        for (int i=0;i<m-1;i++){
            hs.add(relations[0][i]);
        }
        System.out.println(hs.size());
        for (int ss:hs)
            System.out.print(ss);
    }

}
