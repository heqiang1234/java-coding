package com.leetcode.Algorithm.huadongchuangkou;

/**
 * @author heqiang
 * @date 2025年07月31日16:08
 */
public class Quesiton1343NumOfSubarrays {

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
     * @param arr
     * @param k
     * @param threshold
     * @return
     */
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        double numSum = 0;
        int res = 0 ;
        for (int i = 0; i < arr.length; i++) {
            numSum += arr[i];
            if (i < k - 1){
                continue;
            }
            if (Double.compare(numSum / k,threshold * 1.0) > 0 ){
                res++;
            }
            numSum -= arr[i - k + 1];
        }
        return res;
    }

}
