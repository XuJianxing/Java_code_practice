package foroffer.offer;
/* 字符串的排列
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
import java.util.ArrayList;
import java.util.Arrays;

public class _38Permutation {
    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);  // 排序是为了防止使用重复字符
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }
    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s){
        if (s.length() == chars.length){
            ret.add(s.toString());
            return;
        }
        for (int i = 0;i < chars.length; i++){
            if (hasUsed[i]) continue;
            if (i != 0 && chars[i] == chars[i-1] && !hasUsed[i-1]) continue;  // 同sort为了防止重复
            hasUsed[i] = true;
            s.append(chars[i]);
            System.out.println(i+"_"+s.toString());
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length()-1);
            System.out.println("---"+i+"_"+s.toString());
            hasUsed[i] = false;
        }
    }

    public static void main(String[] args){
        _38Permutation per = new _38Permutation();
        per.Permutation("abcd");
    }
}
