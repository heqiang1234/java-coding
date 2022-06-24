package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2022-06-23 10:32
 * @description: 611. 有效三角形的个数
 **/
public class Question611_1TriangleNumber {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] == 0)
                    continue;

                int left = i + 1, right = j - 1;
                while (left < right) {
                    int mid = left + right >> 1;
                    if (nums[j] + nums[mid] > nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left == right && nums[right] + nums[j] > nums[i]) res += j - right;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{0,1,1,1}));
    }
}
