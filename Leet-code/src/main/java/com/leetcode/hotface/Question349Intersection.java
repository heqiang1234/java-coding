package com.leetcode.hotface;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author HQ
 * @program: java-coding
 * @description: 349. 两个数组的交集
 * @date 2022-09-15 21:26:10
 */
public class Question349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                if (!resList.contains(nums2[i])) resList.add(nums2[i]);
            }
        }
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pre = Integer.MIN_VALUE;
        int count = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 > len2 ? len1 : len2;
        int i = len1 - 1;
        int j = len2 - 1;
        List<Integer> res = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 == num2) {
                if (num1 != pre) {
                    pre = num1;
                    res.add(num1);
                    count++;
                }
                i--;j--;
            } else if (num1 > num2) {
                i--;
            } else {
                j--;
            }
        }
        int [] resInt = new int[count];
        for (int t : res) {
            resInt[--count] = t;
        }
        return resInt;
    }

    public static void main(String[] args) {
        intersection1(new int[]{4,9,5}, new int[]{9,4,9,8,4});
    }

}
