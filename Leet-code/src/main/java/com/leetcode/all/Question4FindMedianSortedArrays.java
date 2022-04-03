package com.leetcode.all;

/**
 * @program: demo
 * @description: 4. 寻找两个正序数组的中位数
 * @author: Mr.He
 * @create: 2022-03-26 14:43
 **/
public class Question4FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int midLen = (len1 + len2) / 2 + 1;
        Boolean flag = ((len1 + len2) % 2) == 0 ? true : false;
        int tempI = 0;
        int t1 = 0;
        int t2 = 0;
        double sum = 0.0D;
        int tempT1 = 0;
        int tempT2 = 0;
        //midLen = midLen - 1;
        while (tempI < midLen) {
            tempT2 = t2 >= len2 ? Integer.MAX_VALUE : nums2[t2];
            for (int i = t1; i < len1; i++,t1++) {
                if (nums1[i] <= tempT2) {
                    tempI++;
                } else {
                    break;
                }
                if (tempI == midLen) {
                    sum += nums1[i];
                    break;
                }
                if (tempI == midLen - 1) {
                    if (flag) sum += nums1[i];
                }
            }

            tempT1 = t1 >= len1 ? Integer.MAX_VALUE : nums1[t1];
            for (int i = t2; i < len2; i++,t2++) {
                if (nums2[i] <= tempT1) {
                    tempI++;
                } else {
                    break;
                }
                if (tempI == midLen) {
                    sum += nums2[i];
                    break;
                }
                if (tempI == midLen - 1) {
                    if (flag) sum += nums2[i];
                }
            }
        }
        return flag ? sum / 2 : sum;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
    }
}
