package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年07月30日16:55
 */
public class Question2419longestSubarray {
    public static int longestSubarray(int[] nums) {
        int len = nums.length;
        int res = 0,cnt = 0,maxNum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > maxNum){
                res = 1;
                cnt = 1;
                maxNum = nums[i];
            } else if (nums[i] == maxNum){
                cnt++;
                res = Math.max(cnt,res);
            } else {
                cnt = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        longestSubarray(new int[]{1,2,3,3,2,2});
    }
}
