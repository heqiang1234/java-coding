package com.leetcode.year2026;

import org.springsource.loaded.ri.JavaMethodInvoker;

/**
 * @author heqiang
 * @date 2026年05月19日16:10
 */
public class Q643FindMaxAverage {

    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     *
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * 示例 2：
     *
     * 输入：nums = [5], k = 1
     * 输出：5.00000
     *
     *
     * */

    public static double findMaxAverage(int[] nums, int k) {
        double sumNum = 0.0,res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sumNum += nums[i];

            // 长度小于K，则表示还不满足条件
            if ( i -k + 1 < 0)continue;

            // 计算当前窗口的平均值
            res = Math.max(res,sumNum / k);

            // 计算完止呕，需要将现有窗口最前面的值去掉，给后面依次数字计入窗口
            sumNum -= nums[i - k + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        findMaxAverage(new int[]{1,12,-5,-6,50,3},4);
    }
}
