package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 3184. 构成整天的下标对数目 I
 * @date 2024-10-22 21:32:11
 */
public class Question3184CountCompleteDayPairs {

    public static int countCompleteDayPairs(int[] hours) {
        int count = 0;
        int len = hours.length - 1;
        int j = 0;
        while (j <= len) {
            for (int i = j + 1; i <= len; i++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++;
                }
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countCompleteDayPairs(new int[]{72,48,24,3}));
    }
}
