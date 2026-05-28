package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-04-28 10:22
 * @description: 905. 按奇偶排序数组
 **/
public class Question905SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int len = nums.length - 1;
        int left = 0, right = len;
        while (left < right){
            while (nums[left] % 2 == 0){
                left++;
                if (left > len){
                    break;
                }
            }

            while (nums[right] % 2 != 0){
                right--;
            }

            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        sortArrayByParity(new int[]{0});
    }

}
