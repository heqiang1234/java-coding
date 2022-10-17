package com.leetcode.daimasuixianglu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Mr.He
 * @create: 2022-10-17 16:35
 * @description: 1.两数之和
 **/
public class Day06_1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])){
                return new int[]{i,temp.get(target - nums[i])};
            } else {
                temp.put(nums[i],i);
            }
        }
        return nums;
    }

}
