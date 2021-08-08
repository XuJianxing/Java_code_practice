package exams.xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

public class test31 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        ArrayList<Character> al = new ArrayList<>();
        int flag = 0;
        for (int i=0; i<in.length(); i++){
            if (in.charAt(i) == '(')
                flag += 1;
            else if (in.charAt(i) == ')')
                flag --;
            else if (flag == 0){
                if (in.charAt(i) != '<')
                    al.add(in.charAt(i));
                else if (al.size()!=0) al.remove(al.size()-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            sb.append(al.get(i));
        }
        System.out.println(sb.toString());
    }

}
