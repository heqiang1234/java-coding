package com.leetcode.year2023.signin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2283. 判断一个数的数字计数是否等于数位的值
 * @date 2023-01-11 22:33:19
 */
public class Question2283digitCount {

    public static boolean digitCount(String num) {
        int len = num.length();
        int maxLen = len;
        for (int i = 0; i < len; i++) {
            maxLen = Math.max(maxLen,num.charAt(i) - '0');
        }
        int [] nums = new int[maxLen + 1];
        for (int i = 0; i < len; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < len; i++) {
            nums[num.charAt(i) - '0']--;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        digitCount("030");
    }
}
