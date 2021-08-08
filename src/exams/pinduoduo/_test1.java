package exams.pinduoduo;

// 本题为考试多行输入输出规范示例，无需提交，不计分。
/*
找到最小方差的三个数
 */
import java.util.Scanner;
import java.util.Arrays;

//public class Main {
public class _test1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nlist = new int[n];
        for(int i = 0; i < n; i++){
            nlist[i] = sc.nextInt();
        }
        int min_index=1;
        double temp = (nlist[0]+nlist[1]+nlist[2])/3.0;
        double min = ((nlist[0]-temp)*(nlist[0]-temp)+
                (nlist[1]-temp)*(nlist[1]-temp)+
                (nlist[2]-temp)*(nlist[2]-temp))/3.0;
        Arrays.sort(nlist);
        for (int i=1;i<nlist.length-2;i++){
            temp = (nlist[i]+nlist[i+1]+nlist[i+2])/3.0;
            double ans = ((nlist[i]-temp)*(nlist[i]-temp)+
                    (nlist[i+1]-temp)*(nlist[i+1]-temp)+
                    (nlist[i+2]-temp)*(nlist[i+2]-temp))/3.0;
            if (ans<=min) min = ans;
        }
        System.out.println(String.format("%.2f",min));
    }
}