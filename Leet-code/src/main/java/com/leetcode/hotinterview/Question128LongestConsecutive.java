package com.leetcode.hotinterview;

import java.util.*;

/**
 * @program: demo
 * @description: 128. 最长连续序列
 * @author: Mr.He
 * @create: 2022-01-21 09:20
 **/
public class Question128LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for (int num : set) {
            int oneLen = 0;
            if (!set.contains(num -1)){
                while (set.contains(num)) {
                    set.remove(num);
                    num = num + 1;
                    oneLen++;


                }
                maxLen = Math.max(oneLen, maxLen);
            }
        }
        return maxLen;
    }
    public static int longestConsecutive2(int[] nums) {
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int right = map.get(nums[i]);
            while (map.containsKey(right + 1)){
                right = map.get(right + 1);
            }
            map.put(nums[i],right);

            maxLen = Math.max(maxLen,right - nums[i] + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive2(nums));
    }

}
