package foroffer.leetcode;
/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
 */
public class _14longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return new String("");
        int min_len = strs[0].length();
        int max = 0;
        boolean f=true;
        for(int i=1;i<strs.length;i++)
            if(min_len>strs[i].length())
                min_len = strs[i].length();
        for (int i=0;i<min_len;i++){
            for (int j=0;j<strs.length-1;j++){
                f=f&strs[j].charAt(i)==strs[j+1].charAt(i);
            }
            if(f)
                max+=1;
        }
        return strs[0].substring(0,max);
    }
}
