package com.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 2006. 差的绝对值为 K 的数对数目
 * @author: Mr.He
 * @create: 2022-02-09 15:06
 **/
public class Question2006CountKDifference {

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countKDifference2(int[] nums, int k) {
        int count = 0, len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            count += map.getOrDefault(nums[i] - k, 0) + map.getOrDefault(nums[i] + k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1};
        System.out.println(countKDifference2(nums, 1));
    }
}
