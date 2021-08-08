package exams.zhaohangxinyongka;
/*
机器人左右移动L，R 10^100次
 */
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length = s.length();
        int[] counts = new int[length];
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'R'){
                int temp = RFindFirstL(s, i);
                if ((temp - i & 1) == 0) counts[temp] += 1;
                else counts[temp-1] += 1;
            }
            else if (s.charAt(i) == 'L'){
                int temp = LFindFirstR(s, i);
                if ((i - temp & 1) == 0) counts[temp] += 1;
                else counts[temp+1] += 1;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(counts[i]);
            if (i!=length-1)
                System.out.print(" ");
        }
    }
    private static int RFindFirstL(String s, int begin){
        for (int i = begin; i < s.length(); i++)
            if (s.charAt(i) == 'L') return i;
        return s.length()-1;
    }
    private static int LFindFirstR(String s, int end){
        for (int i = end; i >= 0; i--)
            if (s.charAt(i) == 'R') return i;
        return 0;
    }
}