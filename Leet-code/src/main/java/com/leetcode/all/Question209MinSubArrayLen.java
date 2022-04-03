package com.leetcode.all;

import java.util.HashMap;

/**
 * @program: demo
 * @description: 209. 长度最小的子数组
 * @author: Mr.He
 * @create: 2022-03-06 21:31
 **/
public class Question209MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        HashMap<Integer,Integer> res = new HashMap<>();
        int ret = 0;
        int sum = 0;
        int tempLen = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res.put(sum,i);
            tempLen = res.getOrDefault(sum - target,0);
            if (res.containsKey(sum - target)) {
                if (flag){
                    ret = Math.min(ret,i - tempLen);
                } else {
                    ret = Math.min(Integer.MAX_VALUE,i - tempLen);
                    flag = true;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] arr = {1,4,4};
        System.out.println(minSubArrayLen(4, arr));
    }
}
