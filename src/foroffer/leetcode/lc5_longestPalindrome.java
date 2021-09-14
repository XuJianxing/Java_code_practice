package foroffer.leetcode;

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
     */
    public String longestPalindrome_2(String s) {
        return null;
    }
    /**
     * Manacher算法（马拉车）————O(n)回文子串
     * https://www.cnblogs.com/fan1-happy/p/11166182.html
     */

}
