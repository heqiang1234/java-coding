package com.leetcode.hotinterview;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 70. 爬楼梯
 * @author: Mr.He
 * @create: 2022-01-16 22:02
 **/
public class Question70ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 0) {
            return 0;
        }
        int[] res = new int[n + 1];
        Arrays.fill(res, 0);
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
