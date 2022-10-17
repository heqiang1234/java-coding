package com.leetcode.daimasuixianglu;

/**
 * @author HQ
 * @program: java-coding
 * @description: 977.有序数组的平方
 * @date 2022-10-13 19:43:04
 */
public class Day02_977SortedSquares {

    public int[] sortedSquares(int[] nums){
        int count = 0;//统计负数
        int len = nums.length - 1;
        for (int i = 0; i <= len; i++) {
            if (nums[i] < 0){
                count++;
            } else {
                break;
            }
        }

        for (int i = 0; i <= len; i++) {
            int tmep = nums[i];
            nums[i] = tmep * tmep;
        }

        if (count > 0){
            int left = 0,right = len;
            int [] res = new int[len + 1];
            int i = len;
            while (left <= right){
                if (nums[left] > nums[right]){
                    res[i--] = nums[left];
                    left++;
                } else {
                    res[i--] = nums[right];
                    right--;
                }
            }
            return res;
        } else {
            return nums;
        }
    }

    public static void main(String[] args) {
       int [] m =  sortedSquares(new int[]{-4,-1,0,3,10});
        System.out.println(m);
    }
}
