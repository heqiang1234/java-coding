package com.leetcode.year2023.face150;

/**
 * @author HQ
 * @program: java-coding
 * @description: 合并两个有序数组
 * @date 2023-11-11 12:43:11
 */
public class Question88MergeTwoOrderArray {

    //比较m+n次，
    // 1.空间换时间
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length -1;
        int i = m - 1, j = n -1 ;
        //从后往前进行覆盖的处理。从末尾处理
        while (j >= 0 ) {
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[len] = nums1[i];
                len--;
                i--;
            } else {
                nums1[len] = nums2[j];
                len--;
                j--;
            }
        }
        return;
    }

    // 4，5，6，0，0，0    1，2，3
    // 1，5，6，0，0，0    4，2，3
    // 1，2，6，0，0，0    4，5，3
    // 1，2，3，0，0，0    4，5，6
    // 1，2，3，4，5，6    4，5，6

    // 5.000..0,0   2,5,
    // 2,6,7,0,0,0   5（here）.5,6
    // 2,5,7,0,0,0   6,5,6
    // 2,5,5,0,0,0   6,7(here),6

    public static void main(String[] args) {
        merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
