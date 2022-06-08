package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1037. 有效的回旋镖
 * @date 2022-06-08 21:26:28
 */
public class Question1037IsBoomerang {

    public boolean isBoomerang(int[][] points) {
        int[] v1 = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = {points[2][0] - points[0][0], points[2][1] - points[0][1]};
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

}
