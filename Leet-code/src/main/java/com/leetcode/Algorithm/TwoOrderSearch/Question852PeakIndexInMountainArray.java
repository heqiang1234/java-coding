package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-24 11:01
 * @description: 852.山峰数组的峰顶索引
 **/
public class Question852PeakIndexInMountainArray {

    //O(log(n))方法，二分
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid - 1] > arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    //O(log(n))方法，三分
    public static int peakIndexInMountainArray1(int[] arr) {
        int left = 1, right = arr.length - 1;
        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = right - (right - left) / 2;
            if (arr[m1] > arr[m2]) {
                right = m2 -1;
            } else {
                left = m1 + 1;
            }
        }
        return right;
    }

    //O（n）方法
    public static int peak1(int[] arr) {
        int index = 0, maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
    }

}
