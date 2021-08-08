package exams.wangyihuyu;

import java.util.*;
public class MinCostString2 {
    private static ArrayList<String> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String str="ASDFGH";
        dfs(str.toCharArray(),0);
        int[] ans=new int[n];
        int c=0;
        while(c<n) {
            String str1=sc.nextLine();
            int sum=Integer.MAX_VALUE;
            for(String s:arrayList)
            {
                int dis=distance(s,str1);
                if(sum>dis)
                    sum=dis;
            }
            ans[c++]=sum;
        }
        for(int i : ans)
            System.out.println(i);
    }
    private static void dfs(char[] chars,int i) {
        if(i == chars.length)
            arrayList.add(String.valueOf(chars));
        for(int j = i;j<chars.length;j++) {
            if(j == i)
                dfs(chars,i+1);
            else {
                swap(chars, i, j);
                dfs(chars,i+1);
                swap(chars, i,j);
            }
        }
    }
    private static int distance(String a, String b) {
        int[] path = new int[b.length()];
        for (int i = 0; i < path.length; i++)
            path[i] = a.indexOf(b.charAt(i));
        int p = 0;
        int sum = 0;
        for (int i : path) {
            sum += Math.abs(p - i);
            p = i;
        }
        return  sum;
    }
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
/*
public class Main
{
    static ArrayList<String> list=new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        String str="ASDFGH";
        allSort(str.toCharArray(),0);
        int[] ans=new int[n];
        int count=0;
        while(count<n)
        {
            String str1=sc.nextLine();
            int curSum=Integer.MAX_VALUE;
            for(String target:list)
            {
                int dis=getDistace(target,str1);
                if(curSum>dis)
                    curSum=dis;
            }
            ans[count++]=curSum;

        }
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    }
}
*/
