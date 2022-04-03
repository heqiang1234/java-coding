package com.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 1748. 唯一元素的和
 * @author: Mr.He
 * @create: 2022-02-06 08:59
 **/
public class Question1748SumOfUnique {

    public static int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        for (Map.Entry<Integer,Integer> mapp: map.entrySet()) {
            if (mapp.getValue() == 1){
                res += mapp.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,1};
        System.out.println(sumOfUnique(nums));
    }

}
