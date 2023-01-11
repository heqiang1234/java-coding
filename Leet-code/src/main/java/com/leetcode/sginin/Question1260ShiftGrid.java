package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1260. 二维网格迁移
 * @date 2022-07-20 21:40:45
 */
public class Question1260ShiftGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res= new ArrayList<>();
        int widLen = grid.length;
        int higLen = grid[0].length;
        int nextI =  widLen - 1;
        int nextJ =  higLen - 1;
        int temp = grid[nextI][nextJ];
        for (int i = 0; i < widLen; i++) {
            List<Integer> tm = new ArrayList<>();
            for (int j = 0; j < higLen; j++) {
                //储存下一个要替换的位置
                grid[i][j] = temp;
                tm.add(grid[i][j]);
                if (nextI == widLen - 1 && nextJ == higLen - 1){
                    nextI = 0;
                    nextJ = 0;
                } else if (nextI == widLen - 1 && nextJ != higLen - 1){
                    nextI = 0;
                    nextJ = j + 1;
                } else if ( nextI != widLen - 1 && nextJ == higLen - 1 ){
                    nextI = i + 1;
                    nextJ = j;
                } else {
                    nextI = i + 1;
                    nextJ = j;
                }
            }
            res.add(tm);
        }
        return res;
    }

    public static void main(String[] args) {
        shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1);
    }

}
