package com.lcsaf.dp;

public class Q2466countGoodStrings {

    public int countGoodStrings(int low, int high, int zero, int one) {
        return dp(low,high," ");
    }

    public int dp(int low, int high,String str) {
        if (str.length() >= low && str.length() <= high) return 1;
        if (str.length() < low) return 0;
        if (str.length() > high) return 0;
    }


}
