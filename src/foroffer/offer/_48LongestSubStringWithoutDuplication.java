package foroffer.offer;

import java.util.Arrays;

/* 最长不含重复字符的子字符串
子字符串，计算满足条件的最长的子字符串的长度。假设字符串只包含'a'-'z'字符。
——
创建一个长度为26的数组position，记录每个字符上次出现在字符串中的位置的下标。
所有值初始化为-1。在扫描字符串时遇到某个字符，就把该字符在字符串中的位置存储到数组对应的元素中。
 */
public class _48LongestSubStringWithoutDuplication {
    public int LongestSubStringWithoutDuplication(String str){
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int cur_i = 0; cur_i < str.length(); cur_i++){
            int hashedIndex = str.charAt(cur_i) - 'a';  // 字符对应的码
            int pre_i = preIndexs[hashedIndex];  // 这个字符之前出现的位置
            if (pre_i == -1 || cur_i - pre_i > curLen)  // 如果没出现过或者出现的位置超过长度了
                curLen++;
            else {  // 否则说明重复了
                maxLen = Math.max(maxLen, curLen);
                curLen = cur_i - pre_i;  // 重新计算长度。这是减去重复字符上一次出现的位置。
            }
            preIndexs[hashedIndex] = cur_i;  // 修改上次出现的位置
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }
}
