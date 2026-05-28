package com.leetcode.sginin;

import java.util.HashSet;
import java.util.Set;

/**
 * @author heqiang
 * @date 2025年12月01日9:26
 */
public class Question1015SmallestRepunitDivByK {

    public static int smallestRepunitDivByK(int k) {
        Set<Integer> tmp = new HashSet<Integer>();
        int x = 1 % 7;
        while (x > 0 && tmp.add(x)) {
            x = (10 * x + 1) % k;
        }
        return x > 0 ? -1 : tmp.size();
    }

//    public static long pow(int x, int n) {
//        long res = 1;
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                res *= x;
//            }
//            x *= x;
//            n >>= 1;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
//        System.out.println(smallestRepunitDivByK(23));
//        pow(10,6);
//        pow(10,9);
        double x = 0.499999,y = 10;
        double entrustBalance = x * y;
        double entrustBuyBalance = 0.0d;
        double businessFrozenBalance = 0.0d;
        //if (JRESStringUtils.equals(HSConstants.CNST_ENTRUST_PROP_PURCHASE_IMF, entrust.getEntrustProp())) {
            entrustBuyBalance = 0 - entrustBalance;
            businessFrozenBalance = 0 - entrustBalance;
        //}

        System.out.println(entrustBuyBalance);
    }

}
