package foroffer.leetcode;

import java.util.ArrayList;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class lc5_longestPalindrome {
    /**
     * 思路1：遍历每个字符，以该字符为中心左右累加字符，直到最长回文串。（中心扩展）
     *      （注意：要区分奇数个中心字符和偶数个情况）
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
    /**
     * 思路2：倒置之后，找最长公共子串，这个最长公共子串就是满足的结果
     * 怎么找最长公共子串：
     *   设一个2维矩阵，对应位置字符相同为1，然后找对角线中最长的连续1的个数
     */
    public String longestPalindrome_2(String s) {
        return null;
    }
    /**
     * Manacher算法（马拉车）————O(n)回文子串
     * https://www.cnblogs.com/fan1-happy/p/11166182.html
     * 这里是返回长度
     */
    public int longestPalindrome_3(String s) {
        char[] s_new = init(s);  // 组成新字符串
        int max_len = -1;  // 最长回文长度
        int id = 0;
        int mx = 0;
        int[] p = new int[s_new.length];
        for(int i = 1; i < s_new.length; i++) {
            if(i < mx)
                p[i] = Math.min(p[2 * id - i],mx - i);//上面图片就是这里的讲解
            else p[i] = 1;
            // *** Java代码这里要改一下，因为s_new[i + p[i]]到最后数组越界了 ***
            while(s_new[i - p[i]] == s_new[i + p[i]])//不需边界判断，因为左有'$'，右有'\0'标记；
                p[i]++;//mx对此回文中点的贡献已经结束，现在是正常寻找扩大半径
            if(mx < i + p[i]) {//每走移动一个回文中点，都要和mx比较，使mx是最大，提高p[i]=min(p[2*id-i],mx-i)效率
                id = i;//更新id
                mx = i + p[i];//更新mx
            }
            max_len = Math.max(max_len, p[i] - 1);
        }
        return max_len;
    }
    private char[] init(String s){
        char[] t = new char[s.length() * 2 + 3];
        if (s.length() < 1) return t;
        t[0] = '$';
        t[1] = '#';
        int j = 2;
        for (int i = 0; i < s.length(); i++) {
            t[j++] = s.charAt(i);
            t[j++] = '#';
        }
        t[j] = '#';
        System.out.println(t);
        return t;
    }
    /**
     * 力扣 示例代码
     */
    public String longestPalindrome_4(String s) {
        int start = 0, end = -1;
        StringBuilder t = new StringBuilder("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        ArrayList<Integer> arm_len = new ArrayList<>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

    public static void main(String[] args){
        lc5_longestPalindrome test = new lc5_longestPalindrome();
        String s = "aacbbabbcdd";
        System.out.println(test.longestPalindrome(s));
        System.out.println(test.longestPalindrome_2(s));
        System.out.println(test.longestPalindrome_4(s));
        System.out.println(test.longestPalindrome_3(s));
    }
}
