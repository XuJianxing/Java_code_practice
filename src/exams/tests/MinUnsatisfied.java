package exams.tests;
/*
一队顾客，标号从1到n，一开始，每位顾客的位置就是i，每人有两个属性a,b。
每个顾客不满意程度=他前面的人数*a+后面的人数*b 求最小不满意度
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MinUnsatisfied {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pre = new int[n];
        int[][] abs = new int[n][2];
        for (int i = 0; i < n; i++) {
            abs[i][0] = sc.nextInt();
            abs[i][1] = sc.nextInt();
            pre[i] = i;
        }
        backtracking(abs, pre, new boolean[n], new ArrayList<>());
        System.out.println(min);
    }
    static public int min=Integer.MAX_VALUE;
    static private void backtracking(int[][] abs, int[] pre, boolean[] hasUsed, ArrayList<Integer> s){
        if (s.size() == pre.length){
            min=Integer.MAX_VALUE;
            int temp = 0;
            for (int i=0;i<pre.length;i++){
                // temp += abs[i][0] * (s.get(i)-i+1) + abs[i][1] * (i-s.get(i));
                temp += abs[s.get(i)][0] * i + abs[s.get(i)][1] * (pre.length-i-1);
            }
            min = Math.min(temp, min);
            return;
        }
        for (int i = 0;i < pre.length; i++){
            if (hasUsed[i]) continue;
            //if (i != 0 && pre[i] == pre[i-1] && !hasUsed[i-1]) continue;  // 同sort为了防止重复
            hasUsed[i] = true;
            s.add(pre[i]);
            backtracking(abs, pre, hasUsed, s);
            s.remove(s.size()-1);
            hasUsed[i] = false;
        }
    }

}
