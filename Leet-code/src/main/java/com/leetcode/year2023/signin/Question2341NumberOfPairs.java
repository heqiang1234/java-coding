package com.leetcode.year2023.signin;

import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2023-02-16 12:26
 * @description: 2341. 数组能形成多少数对
 **/
public class Question2341NumberOfPairs {

    public static int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0,right = 0;
        int countA = 0,countB = 0;
        while (left < n){
            right = left+ 1;
            if (right >= n) break;
            if (nums[left] == nums[right]){
                countA++;
                left = right + 1;
            } else {
                left = right;
            }
        }
        countB = n - countA * 2;
        return new int[]{countA,countB};
    }

    public static void main(String[] args) {
        numberOfPairs(new int[]{1,3,2,1,3,2,2});
    }

}
