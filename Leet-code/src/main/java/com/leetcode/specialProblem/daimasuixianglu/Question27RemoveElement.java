package com.leetcode.specialProblem.daimasuixianglu;

/**
 * @author: Mr.He
 * @create: 2022-06-22 16:49
 * @end: 2022-06-22 17:07
 * @description: 27, 移除元素
 **/
public class Question27RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            while (left < len && left >= 0  && nums[left] != val){
                left++;
            }

            while (right < len && right >= 0 && nums[right] == val){
                right--;
            }
            if (left >= right){
                return left;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return left;
    }

    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3},3);
    }

}
