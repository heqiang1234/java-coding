package com.leetcode.HightInterview;

import java.util.HashMap;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1.两数之和
 * @date 2022-08-09 23:50:19
 */
public class Question01TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (map.containsKey(target - temp)) {
                int index = map.get(target - temp);
                    return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }

}
