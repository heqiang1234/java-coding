package com.leetcode.specialProblem.tenxunjingxuan;

import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2022-06-10 15:48
 * @description: 16. 最接近的三数之和
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question16ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int minNum = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int tempMinNum = minNum;
                minNum = Math.abs(sum - target) > Math.abs(minNum) ? minNum : sum - target;
                // = Math.min(Math.abs(sum - target), Math.abs(minNum));
                if (minNum != tempMinNum) {
                    res = sum;
                }
                int nowNum = sum - target;
                // if (tempMinNum != minNum){
                //     while (left < right && nums[left] == nums[left + 1]) left++;
                //     while (left < right && nums[right] == nums[right - 1]) right--;
                //     left++;
                //     right--;
                // }
                if (sum == target) {
                    return target;
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}
