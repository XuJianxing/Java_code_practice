package exams.sougou;
/*
判断满足匹配规则的IP地址
 */
import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        int N = Integer.valueOf(in[0]);
        int M = Integer.valueOf(in[1]);
        String[] regex = new String[N];
        String[] ips = new String[M];
        for(int i = 0; i < N; i++)
            regex[i] = sc.nextLine();
        for (int i = 0; i < M; i++)
            ips[i] = sc.nextLine();
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(regex[j]+"___"+ips[i]);
                if (judge(regex[j], ips[i])){
                    result[i] = 1;
                    break;
                }
            }
        }
        for (int i = 0; i < M; i++)
            System.out.print(result[i]+" ");
    }
    private static boolean judge(String regex, String ip){
        // *在前：
        if (regex.charAt(0) == '*'){
            for (int i = regex.length()-1,j = ip.length()-1; i >= 0  && j >= 0; i--,j--) {
                if (regex.charAt(i) != ip.charAt(j))
                    return  regex.charAt(i) == '*';  // 出现*了直接返回
            }
            return true;
        }
        // 第二种判断方法：*在后
        for (int i = 0,j = 0; i < regex.length() && j < ip.length(); i++,j++) {
            if (regex.charAt(i) != ip.charAt(j))
                return  regex.charAt(i) == '*';  // 出现*了直接返回
        }
        return true; // false是不匹配
    }

}