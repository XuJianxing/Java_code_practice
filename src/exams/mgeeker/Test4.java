package exams.mgeeker;
// 最大连续自段和
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        int allsum = 0;
        for (int i=0;i<n;i++){
            allsum += array[i];
        }

        int subsum = 0;
        int min = 0;
        for (int i=0;i<n;i++){
            if (subsum>=0){
                subsum = array[i];
            }
            else {
                if (subsum <= min) min = subsum;
                subsum += array[i];
                if (subsum <= min) min = subsum;
            }
        }

//        int sum=0,min=array[0];  // max要初始化为数组第一个数，而不是自己设的数。因为从第一个开始遍历
//        for (int i:array){
//            if(sum<0)
//                sum += i;
//            else
//                sum = i;  // 这里，如果sum<=0了，则说明前段没用了，sum从现在开始重新考虑
//            min = Math.min(min, sum);
//        }

        System.out.println(allsum-min);
    }
}
