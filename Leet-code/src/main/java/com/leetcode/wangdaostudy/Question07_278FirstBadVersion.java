package com.leetcode.wangdaostudy;

/**
 * @author HQ
 * @program: java-coding
 * @description: 278. 第一个错误的版本
 * @date 2022-08-16 23:47:43
 */
public class Question07_278FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
