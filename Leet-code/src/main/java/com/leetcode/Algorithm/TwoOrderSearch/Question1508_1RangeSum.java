package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1508. 子数组和排序后的区间和
 * @date 2022-07-06 22:37:18
 */
public class Question1508_1RangeSum {

    public static int rangeSum(int[] nums, int n, int left, int right) {
        int newLen = n * (n + 1) / 2;
        int len = nums.length;
        int[] newNums = new int[newLen + 1];
        int tempI = 0;
        int sxIndex = 1;
        while (sxIndex <= newLen){
            int countNum = 0;
            for (int i = tempI; i < len; i++) {
                countNum += nums[i];
                newNums[sxIndex] = countNum;
                sxIndex++;
            }
            tempI++;
        }
        Arrays.sort(newNums);
        int ans = 0;
        for (int i = left; i <= right; i++) {
            ans += newNums[i];
            ans/= 1000000007;
        }
        return ans;
    }

    public static void main(String[] args) {
        rangeSum(new int[]{1,2,3,4},4,1,5);
    }
}
