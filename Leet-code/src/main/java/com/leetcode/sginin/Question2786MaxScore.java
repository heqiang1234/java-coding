package com.leetcode.sginin;

/**
 * 2786.访问数组中的位置使分数最大
 */
public class Question2786MaxScore {

    public static long maxScore(int[] nums, int x) {
        long maxSingle = 0, maxDouble = 0;
        int len = nums.length - 1;

        for (int i = len; i >= 0; i--) {
            int tempNum = nums[i];
            if (tempNum % 2 == 0) {
               // maxSingle = Math.max(tempNum, );
                maxDouble = Math.max(maxSingle + tempNum - x, maxDouble + tempNum);
            } else {
                maxSingle = Math.max(maxDouble + tempNum - x, maxSingle + tempNum);
               // maxDouble = Math.max(tempNum, maxDouble + tempNum - x);
            }
        }

        return nums[0] % 2 == 0 ? maxDouble : maxSingle;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{8,50,65,85,8,73,55,50,29,95,5,68,52,79}, 74));
    }
}
