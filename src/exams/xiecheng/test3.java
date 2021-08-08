package exams.xiecheng;
/* 任务调度
在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间是array[i]，
每个节点同一时间只能执行一个任务，每个节点只能执行连续的任务，
例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
输入数据包含两行
第一行，空格分隔的两个整数m和n，分别表示节点个数和任务个数(m>0,n>=0)
第二行，空格分隔的正整数序列，表示每个任务需要的时间
输出：一个整数，表示最短完成时间
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Main
{
    public static  void main(String[] args)
    {
        int m = 3;
        int n = 5;
        int[] array={1,5,3,4,2};
        System.out.println(schedule(m,array));
    }

    static int schedule(int m,int[] array){
        int left = 0;
        int right = 0;
        int i=0;
        for(;i<array.length;i++)
        {
            right += array[i];  // 数组求和
            left = Math.max(left, array[i]);  // 数组最大值
        }
        return next(left, right, m, array);
    }

    private static int next(int left, int right, int m, int[] array) {
        int midd = (left+right)/2;
        while(left <= right){
            midd = (left+right)/2;
            int t = 0;
            for(int i = 0; i < array.length;){
                int sum = 0;
                //既要满足时间小于某个数
                while(i < array.length && sum + array[i] <= midd){  // 让每个节点执行最大可能长的时间
                    sum += array[i];
                    i++;
                }
                t += 1;  // 统计这样分配节点长度之后，需要多少个节点
                if(t > m)
                    break;  // 如果超过可分配节点数，不可这样分配，那么每个节点需要执行更长时间。
            }
            if(t > m)
                left = midd + 1;
            else
                right = midd - 1;
        }
        return midd;
    }

}