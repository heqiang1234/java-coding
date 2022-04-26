package com.leetcode.Algorithm.sjjg;

/**
 * @author: Mr.He
 * @create: 2022-04-24 21:24
 * @description: 88. 合并两个有序数组
 **/
public class Question88Merge {

    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = 0; i < m + n; i++,j++) {
            if (nums2[j] < nums1[i]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums1[i + 1] = temp;
            } else {

                //nums1[i] = nums2[j];
            }
        }
        return;
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

}
