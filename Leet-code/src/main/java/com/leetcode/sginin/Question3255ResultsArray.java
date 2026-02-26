package com.leetcode.sginin;

import java.util.Arrays;

public class Question3255ResultsArray {

    public int[] resultsArray(int[] nums, int k) {
        int len = nums.length;

        //输入：nums = [1,2,3,4,3,2,5], k = 3
        //
        //输出：[3,4,-1,-1,-1]
        int[] res = new int[len + 1 - k];
        Arrays.fill(res, -1);
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            cnt = i == 0 || nums[i] == nums[i] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }

}
