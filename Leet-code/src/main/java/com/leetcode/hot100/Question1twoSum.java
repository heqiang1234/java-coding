package com.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Question1twoSum {

    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            int tmp = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (tmp == nums[j]){
//                    return new int[]{i,j};
//                }
//            }
//        }
        Map<Integer, Integer> hsnum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (hsnum.containsKey(tmp)) {
                return new int[]{i, hsnum.get(tmp)};
            }
            hsnum.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
