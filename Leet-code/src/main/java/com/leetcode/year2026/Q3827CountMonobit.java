package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年05月21日10:47
 */
public class Q3827CountMonobit {

    /**
     * 给你一个整数 n。
     * 如果一个整数的二进制表示中所有位都相同，则称其为单比特数（Monobit）。
     * 返回范围 [0, n]（包括两端）内单比特数的个数。
     *
     * 示例 1：
     * 输入：n = 1
     * 输出：2
     *
     * 示例 2：
     * 输入：n = 4
     * 输出：3
     *
     * 给你两个正整数 n 和 k。
     *
     * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
     *
     * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
     *
     *
     *
     * 示例 1：
     *
     * 输入： n = 13, k = 4
     *
     * 输出： 2
     *
     * 解释：
     * 最初，n 和 k 的二进制表示分别为 n = (1101)2 和 k = (0100)2，
     *
     * 我们可以改变 n 的第一位和第四位。结果整数为 n = (0100)2 = k。
     *
     * 示例 2：
     *
     * 输入： n = 21, k = 21
     *
     * 输出： 0
     *
     * 解释：
     * n 和 k 已经相等，因此不需要更改。
     *
     * 示例 3：
     *
     * 输入： n = 14, k = 13
     *
     * 输出： -1
     *
     * 解释：
     * 无法使 n 等于 k。
     * @param n
     * @return
     */
    public static int countMonobit(int n,int k){
        if ((n & k) != k)  return -1;
        return Long.bitCount(n ^ k);
    }

    public static void main(String[] args) {
        System.out.println(countMonobit(13,4));
    }

}
