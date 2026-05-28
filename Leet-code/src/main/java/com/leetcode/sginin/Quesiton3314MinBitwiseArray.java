package com.leetcode.sginin;

import java.util.List;

/**
 * @author heqiang
 * @date 2026年01月20日16:18
 */
public class Quesiton3314MinBitwiseArray {

    // 找到第一个
    public static int[] minBitwiseArray(List<Integer> nums) {

        int[] res = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int t  = -1,t1 = 1;
            while ((num & t1) != 0){
                t  = num - t1;
                t1 <<= 1;
            }
            res[i] = t ;

        }
        return res;
    }

    public static void main(String[] args) {

    }

}
