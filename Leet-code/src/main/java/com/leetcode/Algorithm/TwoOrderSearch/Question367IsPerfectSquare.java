package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-25 21:42
 * @description: 367. 有效的完全平方数
 **/
public class Question367IsPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) {
            return true;
        }
        int left = 1, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2 ;
            if ((mid * mid) == num) {
                return true;
            }
            if (( mid * mid) > num) {
                right =(int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(808201));
        System.out.println(isPerfectSquare(808201));;
    }
}

