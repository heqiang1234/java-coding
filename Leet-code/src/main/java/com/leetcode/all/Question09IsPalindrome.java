package com.leetcode.all;

/**
 * @author: Mr.He
 * @create: 2022-06-06 14:29
 * @description: 09.判断是否是回文串
 **/
public class Question09IsPalindrome {

    //字符串的解法
    public static Boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        String res = num + "";
        int left = 0, right = res.length() - 1;
        while (left < right) {
            if (res.charAt(left) == res.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    //不使用字符串
    public static Boolean isPalindrome2(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        int x = num, revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(1221));
    }
}
