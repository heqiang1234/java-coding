package com.leetcode.leet2026.sign;

public class Question66PlusOne {

    public static int[] plusOne(int[] digits) {
        int up = 1;
        int len = digits.length;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + up;
            up = 0;
            if (num >= 10) {
                num = num % 10;
                up = 1;
            }
            digits[i] = num;
        }
        if (up > 0) {
            int[] res = new int[len + 1];
            res[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
       // plusOne(new int[]{1,2,3});
        int [] nuns = new int[]{1,2,3,4};

        nuns = new int[nuns.length + 1];
        nuns[0] = 1;
        System.out.println("wewwew");
    }

}
