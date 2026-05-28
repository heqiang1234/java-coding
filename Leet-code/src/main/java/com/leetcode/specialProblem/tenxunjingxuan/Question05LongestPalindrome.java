package com.leetcode.specialProblem.tenxunjingxuan;

/**
 * @author: Mr.He
 * @create: 2022-06-09 15:52
 * @description: 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question05LongestPalindrome {

    //先使用中间值法。
    public static String longestPalindrome(String s) {
        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = totalLen(i, i, s);
            int len2 = totalLen(i, i + 1, s);
            int maxLen = Math.max(len1, len2);
            if (maxLen > (end - start)){
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    public static int totalLen(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
