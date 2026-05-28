package com.leetcode.sginin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqiang
 * @date 2025年06月22日21:08
 */
public class Quesition73SetZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        StringBuilder str = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    str.append("row").append(i).append("col").append(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    String tmp = "row" + i + "col" + j;
                    if (str.toString().contains(tmp)) {
                        draw(matrix, m, n, i, j);
                    }

                }
            }
        }
        return;
    }

    /**
     * 将识别为0的位置的上下位置置为0
     *
     * @param martix
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    public static void draw(int[][] martix, int m, int n, int x, int y) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == x || j == y) {
                    martix[i][j] = 0;
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

}
