package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-26 21:01
 * @description: 69. x 的平方根
 **/
public class Question69MySqrt {

    public static int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(17));
    }
}
