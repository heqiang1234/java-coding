package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-05-06 16:19
 * @description: 209.二分解决最小子数组
 **/
public class Question209MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        //int index = Arrays.binarySearch(sum, target);
        for (int i = 0; i <= len; i++) {
            int tar = target + sum[i];
            int index = binarySearch(sum,tar);
            if (index >= 0){
                ans = Math.min(ans,index - i);
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid -1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
