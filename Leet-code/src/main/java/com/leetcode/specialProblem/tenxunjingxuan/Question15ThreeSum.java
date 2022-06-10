package com.leetcode.specialProblem.tenxunjingxuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-06-10 09:30
 * @description: 15.三数之和
 **/
public class Question15ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                if (sum > 0){
                    right--;
                }
                if (sum < 0){
                    left++;
                }
            }
        }
        return res;
    }

    public static boolean midSerach(int left, int right, int[] nums, int key) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (key == nums[mid]) {
                return true;
            }
            if (key > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }


}
