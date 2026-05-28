package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author HQ
 * @program: java-coding
 * @description: 81.搜索旋转数组
 * @date 2022-07-04 00:46:25
 */
public class Question81_1Search {

    //最垃圾的方式
    public static boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    //二分
    public static boolean search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int right2 = right;
        //得到中间值的位置22201,10111
        while (left < right2 && (nums[0] > nums[right2] ||  nums[0] == nums[right] && nums[0] == nums[right2])) {
            right2--;
        }

        if (nums[right2] == target || nums[left] == target || nums[right] == target){
            return true;
        }
        if (right == right2){
            return binSearch(nums,left,right,target);
        }
        if (nums[right] > target){
            return binSearch(nums,right2 + 1,right,target);
        }else if (nums[right2] >= target){
            return binSearch(nums,left,right2,target);
        }else {
            return false;
        }
    }


    public static boolean binSearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search1(new int[]{1,0,1,1,1}, 0));
    }
        //[1,0,1,1,1]
    //1,0,1,1,1
    //2,2,2,0,1
    //0
}
