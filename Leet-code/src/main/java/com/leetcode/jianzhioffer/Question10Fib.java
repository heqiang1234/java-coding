package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/24 21:53
 * @desc  青蛙台阶问题和斐波那契数列
 */
public class Question10Fib {

    public static int fib(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        int[] nums = new int[num +1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= num; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2])%1000000007;
        }
        return nums[num];
    }

    public static void main(String[] args) {

        System.out.println(fib(7));
    }
}
