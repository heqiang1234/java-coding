package com.leetcode.specialProblem.daimasuixianglu;

import java.util.Arrays;

/**
 * @author HQ
 * @program: java-coding
 * @description: 59.旋转数组
 * @date 2022-06-26 19:31:30
 */
public class Question59GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], 0);
        }
        int num = 1;
        int lastNum = n * n;
        int [][] res = new int[n][n];
        int i = 0,j = 0;
        while (num != lastNum){
            while (vis[i][j] == 0 && i < n){
                
            }
        }
        return vis;
    }
}
