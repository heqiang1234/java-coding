package com.leetcode.year2023.signin;

import com.leetcode.all.MaxProduct;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2342. 数位和相等数对的最大和
 * @date 2023-11-18 22:48:34
 */
public class Question2342MaximumSum {

    public static int maximumSum(int[] nums) {
        int maxValue = -1;
        Boolean flag = false;
        HashMap<Integer, Integer> keyval = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = getCut(nums[i]);
            if (keyval.containsKey(temp)) {
                flag = true;
                int te = keyval.get(temp);
                maxValue = Math.max(maxValue, nums[i] + te);
                if (nums[i] > te) {
                    keyval.replace(temp, nums[i]);
                }
            } else {
                keyval.put(temp, nums[i]);
            }
        }
        if (!flag) {
            maxValue = -1;
        }
        return maxValue;
    }

    //拆解int
    public static int getCut(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static int maximumSum1(int[] nums) {
        int[] cur = new int[100];//题目 nums[i] < 10 ^ 9  极致 1000000000 最大数位和置不超过100
        Arrays.fill(cur, -2);//默认值
        int maxVlue = -1;
        for (int i = 0; i < nums.length; i++) {
            int temp = getCut(nums[i]);
            maxVlue = cur[temp] == -2 ? maxVlue : Math.max(maxVlue, nums[i] + cur[temp]);
            if (cur[temp] != -2) {
                cur[temp] = Math.max(cur[temp],nums[i]);
            } else {
                cur[temp] = nums[i];
            }
        }
        return maxVlue;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum1(new int[]{10, 12, 19, 14}));
    }

}
