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
     * 3. 自己写的中心扩展法，一个返回int，一个返回String
     */
    public static int longestPalindrome_3(String str){
        if (str == null || str.length() <= 0)
            return 0;
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++){
            int length1 = findPalindrome(str, i, i);
            int length2 = findPalindrome(str, i, i + 1);
            maxLength = Math.max(Math.max(length1, length2), maxLength);
        }
        return maxLength;
    }
    public String longestPalindrome_4(String str){
        String s = "";
        if (str == null || str.length() <= 0)
            return s;
        int maxLength = 0;
        int maxForNow = 0;
        for (int i = 0; i < str.length(); i++){
            int length1 = findPalindrome(str, i, i);
            int length2 = findPalindrome(str, i, i + 1);
            maxForNow = Math.max(length1, length2);
            if (maxForNow > maxLength){
                maxLength = maxForNow;
                if ((maxForNow & 1) == 0)
                    s = str.substring(i - maxLength / 2 + 1, i + maxLength / 2 + 1);
                else
                    s = str.substring(i - maxLength / 2, i + maxLength / 2 + 1);
            }
        }
        return s;
    }
    private static int findPalindrome(String s, int begin, int end){
        while(begin >= 0 && end < s.length()){
            if (s.charAt(begin) == s.charAt(end)){
                begin--;
                end++;
            }
            else break;
        }
        return end - begin - 1;
    }
    /**
     * Manacher算法（马拉车）————O(n)回文子串
     * https://www.cnblogs.com/fan1-happy/p/11166182.html
     * 这里是返回长度
     */
    public static int longestPalindrome_5(String str) {
        // 1.构造新的字符串
        // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < str.length(); i ++) {
            newStr.append(str.charAt(i));
            newStr.append('#');
        }

        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int [] rad = new int[newStr.length()];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newStr.length(); i ++) {
            // 2.1.确定一个最小的半径
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
            // 2.2.尝试更大的半径
            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }
            // 2.3.更新边界和回文中心坐标
            if (i + r - 1> right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }

        // 3.扫描一遍rad数组，找出最大的半径
        int maxLength = 0;
        for (int r : rad) {
            if (r > maxLength) {
                maxLength = r;
            }
        }
        return maxLength - 1;
    }
    /**
     * 力扣 示例代码
     */
    public String longestPalindrome_6(String s) {
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
        System.out.println(test.longestPalindrome_3(s));
        System.out.println(test.longestPalindrome_4(s));
        System.out.println("----------");
        System.out.println(test.longestPalindrome_5(s));
        System.out.println(test.longestPalindrome_6(s));
    }

}
