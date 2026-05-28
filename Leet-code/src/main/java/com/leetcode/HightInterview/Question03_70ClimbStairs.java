package com.leetcode.HightInterview;

/**
 * @author HQ
 * @program: java-coding
 * @description: 70. 爬楼梯
 * @date 2022-08-11 23:16:58
 */
public class Question03_70ClimbStairs {

    static int [] fi = new int[50];
    static {
        fi[0] = 0;fi[1] = 1;fi[2] = 2;
        for (int i = 3; i <= 45; i++) {
            fi[i] = fi[i - 1] + fi[i - 2];
        }
    }

    public int climbStairs(int n) {
        return fi[n];
    }
}
