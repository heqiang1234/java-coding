package com.leetcode.sginin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqiang
 * @date 2025年09月24日10:52
 */
public class Question166FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder resStr = new StringBuilder();
        long a = numerator;
        long b = denominator;
        System.out.println(-1l * -2147483648l);
        String pref = (a * b) >= 0 ? "" : "-";
        a = Math.abs(a); // 保证下面的计算过程不产生负数
        b = Math.abs(b);

        long q = a / b;
        long r = a % b;

        // 证书返回
        if (r == 0) {
            return pref + q;
        }

        Map<Long, Integer> resMap = new HashMap<>();

        resStr.append(pref).append(q).append(".");

        resMap.put(r, resStr.length());
        while (r > 0) {
            r = r * 10;
            q = r / b;
            r = r % b;
            resStr.append(q);
            while (resMap.containsKey(r)) { // 包含 r,则表示进入了循环
                int index = resMap.get(r);
                return resStr.substring(0,index) + "(" + resStr.substring(index) + ")";
            }
            resMap.put(r,resStr.length());
        }
        return resStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, -2147483648));
        System.out.println(fractionToDecimal(1, 1));
        System.out.println(fractionToDecimal(2, 1));
    }

}
