package com.leetcode.all;

/**
 * @program: demo
 * @description: 5. 最长回文子串
 * @author: Mr.He
 * @create: 2022-03-27 18:02
 **/
public class Question05LongestPalindrome {

    public static String longestPalindrome(String s) {

        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = totalLenByMid(i, i, s);
            int len2 = totalLenByMid(i, i + 1, s);
            int maxLen = Math.max(len1,len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int totalLenByMid(int left, int right, String s) {
        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
