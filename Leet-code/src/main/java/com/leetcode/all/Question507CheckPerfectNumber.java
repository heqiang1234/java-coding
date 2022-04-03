package com.leetcode.all;

/**
 * @program: demo
 * @description: 507. 完美数
 * @author: Mr.He
 * @create: 2021-12-31 10:36
 **/
public class Question507CheckPerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i < num) {
                    sum += num / i;
                }
            }
        }
        if (sum != num) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
