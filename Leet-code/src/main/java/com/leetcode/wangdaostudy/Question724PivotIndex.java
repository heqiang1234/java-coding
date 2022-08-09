package com.leetcode.wangdaostudy;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 724. 寻找数组的中心下标
 * @date 2022-08-09 23:07:18
 */
public class Question724PivotIndex {

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total){
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}
