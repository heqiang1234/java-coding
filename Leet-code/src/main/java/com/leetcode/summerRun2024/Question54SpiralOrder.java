package com.leetcode.summerRun2024;

import java.util.ArrayList;
import java.util.List;

public class Question54SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visted = new boolean[row][col];
        int count = (row > 0 ? row : 1) * (col > 0 ? col : 1);

        int[][] dic = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// 模仿dfs，记录方向，上下左右，进行转向
        int indexI = 0, indexJ = 0;
        int decrt = 0;// 方向
        for (int i = 0; i < count; i++) {
            arr.add(matrix[indexI][indexJ]);
            visted[indexI][indexJ] = true; // 记录一个处理过的状态
            int nextRow = indexI + dic[decrt][0], nextCol = indexJ + dic[decrt][1];
            if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || visted[nextRow][nextCol]) {
                decrt = (decrt + 1) % 4;
            }
            indexI += dic[decrt][0];
            indexJ += dic[decrt][1];
        }
        return arr;
    }

    public static void main(String[] args) {

    }


}
