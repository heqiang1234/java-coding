package com.leetcode.Algorithm.huadongchuangkou;

/**
 * @author heqiang
 * @date 2025年07月31日12:58
 */
public class Quesiton2414longestContinuousSubstring {

    public static int longestContinuousSubstring(String s) {
        int res = 1,cnt = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i <= s.length() - 2; i++) {
            if (chars[i] + 1 == chars[i + 1]){
                res = Math.max(res,++cnt);
            } else {
                cnt = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("abacaba"));
    }

}
