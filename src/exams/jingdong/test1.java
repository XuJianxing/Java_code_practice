package exams.jingdong;

import java.util.Scanner;
import java.util.Stack;

class Height{
    int begin;
    int end;
    int max_height;
}

public class test1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=Integer.valueOf(sc.nextLine());
        String s[]=sc.nextLine().split(" ");
        int H[]=new int[s.length];
        for(int i=0;i<s.length;i++){
            H[i]=Integer.valueOf(s[i]);
        }
        Stack<Height> stk=new Stack<>();
        Height first=new Height();
        first.begin=0;
        first.end=0;
        first.max_height=H[0];
        stk.push(first);
        for(int i=1;i<H.length;i++){
            Height md=stk.peek();
            if(H[i]>=md.max_height){
                Height op=new Height();
                op.max_height=H[i];
                op.begin=i;
                op.end=i;
                stk.push(op);
            }
            boolean b=false;
            int max=0;
            while (H[i]<md.max_height){
                max=Math.max(max,md.max_height);
                if(md.begin==0){
                    md.end=i;
                    break;
                }else {
                    stk.pop();
                    md=stk.peek();
                    b=true;
                }
            }
            if(b){
                Height ip=new Height();
                ip.begin=md.end+1;
                ip.end=i;
                ip.max_height=max;
                stk.push(ip);
            }
        }
        System.out.print(stk.size());
    }
}
