package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年09月09日9:51
 */
public class QuestionXXXNumSplit {

    // 不能存在0的。
    public static int[] numSplit(int n) {
        int resI = 0;
        for (int i = 0; i <= 10000; i++) {
            if (judgeNum(i) && judgeNum(n - i)){
                resI = i;
                break;
            }
        }
        return new int[]{resI,n - resI};
    }

    public static boolean judgeNum(int n) {
        if (n == 0) {
            return false;
        }
        while (n > 0) {
            int tmp = n % 10;
            if (tmp == 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numSplit(11).toString());
    }
}
