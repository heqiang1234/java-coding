package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2022-04-25 22:09
 * @description: 1385.数组间距
 **/
public class Question1385FindTheDistanceValue {

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int left = 0, right = arr1.length - 1;
        int len = arr1.length;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Boolean flag = false;
            for (int i = 0; i < arr2.length; i++) {
                if (Math.abs(arr1[mid] - arr2[i]) <= d) {
                    flag = true;
                    count++;
                    break;
                }
            }
            if (flag) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return len - count;
    }

    public static void main(String[] args) {
        System.out.println(findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
    }
}
