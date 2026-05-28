package com.leetcode.sginin;

import java.util.HashSet;
import java.util.Set;

/**
 * @author heqiang
 * @date 2025年09月22日10:53
 */
public class Question3005MaxFrequencyElements {

    public static int maxFrequencyElements(int[] nums) {
        int res = 0, maxNum = 0;
        int[] tmpNum = new int[101];
        Set<Integer> rset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            tmpNum[nums[i]]++;
            rset.add(nums[i]);
        }
        for (int i = 0; i <= 100; i++) {
            if (rset.contains(i)) {
                if (maxNum <= tmpNum[i]) {
                    if (maxNum == tmpNum[i]) {
                        res += tmpNum[i];
                    } else {
                        res = tmpNum[i];
                    }
                    maxNum = Math.max(maxNum, tmpNum[i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        System.out.println(maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }

}
