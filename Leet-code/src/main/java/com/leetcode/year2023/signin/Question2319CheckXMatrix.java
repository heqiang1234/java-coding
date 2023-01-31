package com.leetcode.year2023.signin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2319. 判断矩阵是否是一个 X 矩阵
 * @date 2023-01-31 20:24:54
 */
public class Question2319CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int num = grid[i][j];
                //斜线 y = x || y = n - x
                if (i == j || i + j == n){
                    if (num == 0){
                        return false;
                    }
                } else {
                    if (num != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
