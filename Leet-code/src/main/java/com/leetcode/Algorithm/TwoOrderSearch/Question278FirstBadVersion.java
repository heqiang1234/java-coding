package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-27 10:05
 * @description: 278.第一个错误的版本
 **/
public class Question278FirstBadVersion {

    public static int firstBadVersion(int n) {
        int left = 0, right = n;
        int ans = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static Boolean isBadVersion(int n){
        if (n == 4){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

}
