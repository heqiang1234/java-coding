package com.leetcode.year2023.weekcontest.work232;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2563. 统计公平数对的数目
 * @date 2023-02-15 22:19:14
 */
public class Question1563CountFairPairs {

    /**
     * [-5,-7,-5,-7,-5]
     * -12
     * -12
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return getCurNum(nums,upper) - getCurNum(nums,lower - 1);
    }

    public static long getCurNum(int[] nums, int k) {
        int len = nums.length - 1;
        long ans = 0;
        int left = 0, right = len;
        while (left < right) {
            int temp = nums[right] + nums[left];
            if (temp <= k){
                ans += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    // 选择排序
    public static void selectOrder(int[] nums) {
        int lenNums = nums.length;
        //遍历最外层的数据
        for (int i = 0; i < lenNums; i++) {
            //将当前数据取出来
            int minKey = nums[i];
            //遍历后续是否有
            for (int j = i; j < lenNums; j++) {
                if (minKey > nums[j]) {
                    int tempNum = nums[j];
                    nums[j] = minKey;
                    minKey = tempNum;
                }
            }
            nums[i] = minKey;
        }
    }

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{0, 1, 7, 4, 4, 5}, 3, 6));
    }

}
