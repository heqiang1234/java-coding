package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 01.08. 零矩阵
 * @author: Mr.He
 * @create: 2021-12-06 14:06
 **/
public class Question08SetZeroes {
    public static void setZeros(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {

                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeros(matrix);
    }

}
