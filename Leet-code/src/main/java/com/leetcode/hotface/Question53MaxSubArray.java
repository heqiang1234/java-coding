package com.leetcode.hotface;

/**
 * @author HQ
 * @program: java-coding
 * @description: 53. 最大子数组和
 * @date 2022-09-15 22:11:08
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question53MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i],sum + nums[i]);
            maxNum = Math.max(sum,maxNum);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
