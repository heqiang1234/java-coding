package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年05月20日19:37
 */
public class Q3370smallestNumber {

    public static int smallestNumber(int n) {
        int t = 0;
        while (true){
            t <<= 1;
            t += 1;
            System.out.println(t);
            if (t >= n) return t;
        }
        // return 0;
    }

    public static void main(String[] args) {
        System.out.print(smallestNumber(10));
    }
}
