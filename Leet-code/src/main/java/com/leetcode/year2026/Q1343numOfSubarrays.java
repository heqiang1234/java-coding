package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年05月20日19:54
 */
public class Q1343numOfSubarrays {
    /**
     * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
     *
     * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
     * 输出：3
     * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
     * 示例 2：
     *
     * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
     * 输出：6
     * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
     *
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0,sum = 0;
        for (int i = 0; i < arr.length; i++) {
           // 入窗， 加进去
            sum += arr[i];
            // 不满足条件不进入下面的除法
            if (i - k + 1 < 0) continue;

            // 计算此时的平均值，大于，则+ 1
            count += sum / k >= threshold ? 1 : 0;

            // 出窗口，使用完了，丢掉
            sum -= arr[i - k + 1];
        }
        return count;
    }
}
