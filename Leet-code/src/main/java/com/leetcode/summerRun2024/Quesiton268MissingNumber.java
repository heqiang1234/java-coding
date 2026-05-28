package com.leetcode.summerRun2024;

/**
 * @author heqiang
 * @date 2025年08月05日13:01
 */
public class Quesiton268MissingNumber {

    public int missingNumber(int[] nums) {
        int[] tmp = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]] = 1;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (tmp[i] != 1){
                return i;
            }
        }

        return 0;
    }

}
