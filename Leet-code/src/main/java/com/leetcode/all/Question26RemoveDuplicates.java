package com.leetcode.all;

/**
 * @program: demo
 * @description: 26.删除有序数组中的重复项
 * @author: Mr.He
 * @create: 2022-03-31 10:27
 **/
public class Question26RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1){
            return len;
        }
        int idx = 0; //记录后面那个位置
        for (int i = 1; i < len; i++) {
            if (nums[idx] != nums[i]){
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
