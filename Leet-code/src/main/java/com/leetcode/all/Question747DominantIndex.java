package com.leetcode.all;

/**
 * @program: demo
 * @description: 747. 至少是其他数字两倍的最大数
 * @author: Mr.He
 * @create: 2022-01-13 09:57
 **/
public class Question747DominantIndex {

    public static int dominantIndex(int[] nums) {
        int maxNum = nums[0];
        int maxNumIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxNum){
                if (nums[i] >= maxNum * 2){
                    maxNumIndex = i;
                } else {
                    maxNumIndex = -1;
                }
                maxNum = nums[i];
            } else if (nums[i] < maxNum) {
                if(nums[i] * 2 > maxNum){
                    maxNumIndex = -1;
                }
            }
        }
        return maxNumIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(dominantIndex(nums));
    }
}
