package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-05-14 09:56
 * @description: 540. 有序数组中的单一元素
 **/
public class Question540SingleNonDuplicate {

    //位运算
    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    //二分
    public static int singleNonDuplicate1(int[] nums) {
        int len = nums.length;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (mid + 1 < len && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate1(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

}
