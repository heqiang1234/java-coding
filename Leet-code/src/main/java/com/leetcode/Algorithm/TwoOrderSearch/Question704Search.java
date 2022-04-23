package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.HashMap;

/**
 * @author: Mr.He
 * @create: 2022-04-23 20:07
 * @description: 704.二分查找
 **/
public class Question704Search {

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                return false;
            } else{
                map.put(num,1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));

    }
}
