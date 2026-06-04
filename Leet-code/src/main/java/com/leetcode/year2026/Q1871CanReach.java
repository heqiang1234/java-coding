package com.leetcode.year2026;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author heqiang
 * @date 2026年05月28日16:00
 */
public class Q1871CanReach {

    /**
     * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
     * <p>
     * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
     * s[j] == '0'.
     * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "011010", minJump = 2, maxJump = 3
     * 输出：true
     * 解释：
     * 第一步，从下标 0 移动到下标 3 。
     * 第二步，从下标 3 移动到下标 5 。
     * 示例 2：
     * <p>
     * 输入：s = "01101110", minJump = 2, maxJump = 3
     * 输出：false
     *
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] f = new int[n]; // 1表示 可达
        int[] sum = new int[n + 1];
        f[0] = sum[1] = 1; // 表示true
        for (int i = 1; i < n; i++) {
            if (i >= minJump && s.charAt(i) == '0'
                    && sum[i - minJump + 1] > sum[Math.max(i - maxJump, 0)]) {
                f[i] = 1;
            }
            sum[i + 1] = sum[i] + f[i]; // 前缀和需要维护
        }
        return f[n - 1] == 1;
    }


    public static boolean canReach1(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] f = new int[n];
        f[0] = 1; // 1表示 true， 且后续可以统计这个来处理前缀和数组，从而判断区间内是否存在可达位置
        int[] sum = new int[n + 1]; // 要 + 1的原因是，前缀和，要得到差错一个值，
        // 假设 1，2，3，4   假设 sum[0] = 1.则sum[1] = 3,sum[2] = 6，sum[3] = 10
        // 想得到区间[0,4]的值，那么第4个减去第1个， 得到 10 - 1 = 9， 少了第一个，所以要错开
        // 假设sum[0] = 0, sum[1] = 1,sum[4] = 10, 则 10- 0 = 10，得到了前4个的全部的前缀和。
        sum[1] = 1;
        sum[0] = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump && s.charAt(i) == '0' && ((sum[i - minJump + 1] - sum[Math.max(i - maxJump, 0)]) > 0)){
                f[i] = 1;
            }
            sum[i + 1] = sum[i] + f[i];
        }

        return f[n - 1] == 1;
    }

    public static void main(String[] args) {
        System.out.println(canReach1("00", 1, 1));
    }

}
