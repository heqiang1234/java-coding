package com.leetcode.wangdaostudylevel2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-08-26 14:29
 * @description: 54.螺旋矩阵
 **/
public class Day1_Question54SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        boolean[][] visted = new boolean[row][col];
        int count = (row > 0 ? row : 1) * (col > 0 ? col : 1);
        // for (int i = 0; i < row; i++) {
        //     Arrays.fill(visted[i]);
        // }
        int[][] dic = new int[][]{{0, 1}, {1, 0}, { 0,-1}, {-1, 0}};
        int indexI = 0, indexJ = 0;
        int decrt = 0;
        for (int i = 0; i < count; i++) {
            res.add(matrix[indexI][indexJ]);
            visted[indexI][indexJ] = true;
            int nextRow = indexI + dic[decrt][0], nextCol = indexJ + dic[decrt][1];
            if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col || visted[nextRow][nextCol]) {
                decrt = (decrt + 1) % 4;
            }
            indexI +=dic[decrt][0];
            indexJ += dic[decrt][1];
        }
        return res;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

}
