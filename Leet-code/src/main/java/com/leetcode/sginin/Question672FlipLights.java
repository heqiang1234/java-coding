package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 672. 灯泡开关 Ⅱ
 * @date 2022-09-15 21:12:56
 */
public class Question672FlipLights {

    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n == 1) return 2;
        else if (n == 2) return presses == 1 ? 3 : 4;
        else return presses == 1 ? 4 : presses == 2 ? 7 : 8;
    }
}
