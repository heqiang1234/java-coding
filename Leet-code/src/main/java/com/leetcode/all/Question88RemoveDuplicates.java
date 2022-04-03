package com.leetcode.all;

/**
 * @program: demo
 * @description: 80. 删除有序数组中的重复项 II
 * @author: Mr.He
 * @create: 2022-03-31 11:10
 **/
public class Question88RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2){
            return nums.length;
        }
        int idx = 0;
        int count = 0;
        //只有满足 count < 2的情况下才能进行idx++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] == nums[i]){
                count++;
                if (count <= 2){
                    idx++;
                }
                //idx++;
            } else {
                if (count == 3){
                    nums[idx] = nums[i];
                    count = 0;
                } else {
                    idx++;
                }

            }

        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

}
