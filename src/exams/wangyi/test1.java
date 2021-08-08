package exams.wangyi;
/* 求S（n）

 */
import java.util.Scanner;

public class test1 {
    public static int min(int n){
        if(0<=n&&n<10)
            return n;
        for(int i=0;i<10000;i++){
            String str=String.valueOf(i);
            int sum=0;
            for(int j=0;j<str.length();j++){
                sum=sum+Integer.valueOf(String.valueOf(str.charAt(j)));
            }
            if(sum>=n)
                return i;
            else
                continue;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= Integer.valueOf(sc.nextLine());
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.valueOf(sc.nextLine());
        }
        for(int k=0;k<n;k++){
            System.out.println(min(a[k]));
        }
    }
}