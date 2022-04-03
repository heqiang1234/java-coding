package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 373. 查找和最小的K对数字
 * @author: Mr.He
 * @create: 2022-01-14 10:20
 **/
public class Question373KSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int tempA = 0; //记录第一个数组的遍历的下标
        int tempB = 0; //记录第一个数组的遍历的下标
        int lenA = nums1.length;//第一个数组的长度
        int lenB = nums2.length;//第二个数组的长度

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                List<Integer> next = new ArrayList<>();
                if (k == 0) {
                    break;
                }
                if (nums2[j] != nums2[j + 1] &&  nums1[i + 1] == 1){

                }
                next.add(nums1[i]);
                next.add(nums2[j]);
                res.add(next);
                k--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        List<List<Integer>> res = kSmallestPairs(nums1, nums2, 3);
        for (List<Integer> list : res) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
