package com.leetcode.all;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description: 334. 递增的三元子序列
 * @author: Mr.He
 * @create: 2022-01-12 09:48
 **/
public class Question334IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if (nums.length < 3){
            return false;
        }
        int temp;
        int j = 0;
        int count = 1;
        int temI = 0;//储存大数的下表
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == Integer.MAX_VALUE){
                continue;
            }
            if (set != null || !set.isEmpty()){
                if (set.contains(nums[i])){
                    continue;
                }
            }
            count = 1;
            temp = nums[i];
            j = i + 1;
            set.add(temp);
            while (j < nums.length){
                if (temp < nums[j]){
                    temp = nums[j];
                    count++;
                    temI = j;
                }
                j++;
                if (count == 3){
                    return true;
                }
                if (j == nums.length && count == 1){
                    break;
                } else if (j == nums.length) {
                    count = 1;
                    temp = nums[i];
                    j = temI + 1;
                }
            }
            //nums[temI] =Integer.MAX_VALUE;
        }
        return false;
    }

    public boolean method2(int[] nums){
        if(nums.length < 3){
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num > second){
                return true;
            }
            if(num > first){
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]nums = {1,5,0,4,1,3};
        System.out.println(increasingTriplet(nums));
    }
}
