package com.lcsaf.dp;

public class Q70ClimbStairs {

    public static int climbStairs(int n) {
        int[] f = new int[n+1];


        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        if ( n <= 2) return f[n];
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
       // System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }
}
