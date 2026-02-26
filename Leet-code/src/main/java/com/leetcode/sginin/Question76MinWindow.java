package com.leetcode.sginin;

public class Question76MinWindow {

    //
    public String minWindow(String s, String t) {
        String str = "";

        if (t.length() > s.length()) {
            return "";
        }
        return str;
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length - 1, res = 0, minS = 0, ans = 0;

        for (int i = 0; i <= len; i++) {
            res += gas[i] - cost[i];

            if (res < minS) {
                minS = res;
                ans = i + 1;
            }
        }
        return res < 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{4, 5, 2, 6, 5, 3}, new int[]{3, 2, 7, 3, 2, 9}));
    }

}
