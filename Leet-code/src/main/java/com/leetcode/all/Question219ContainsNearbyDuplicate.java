package com.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 219. 存在重复元素 II
 * @author: Mr.He
 * @create: 2022-01-19 09:18
 **/
public class Question219ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
//            int startInt = Math.abs(i - k);
//            int endInt = i + k;
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(j - i) > k){
                    break;
                }
                if (nums[i] == nums[j] && Math.abs(j - i) <= k){
                    return true;
                }
            }
        }
        return false;
    }

    //使用hash表
    public static boolean containsNearbyDuplicate2(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k){
                return true;
            }
            map.put(num,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate2(nums, 2));
    }
}
