package exams.dongfangcaifu;
/*
输入两个数组，找到第二个数组在第一个数组的位置并打印它后面的数组之后删除它。
 */
import java.util.ArrayList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] s1s = s1.split(",");
        String[] s2s = s2.split(",");
        ArrayList<String> al1 = new ArrayList<>();
        for (int i=0;i<s1s.length;i++)
            al1.add(s1s[i]);
        for (int i=0;i<s2s.length;i++){
            for (int j=0;j<al1.size();j++){
                if (s2s[i].equals(al1.get(j))) {
                    al1.remove(j);
                    for (int k = j; k < al1.size(); k++)
                        System.out.print(al1.get(k) + ",");
                    break;
                }
            }

        }
    }
}
