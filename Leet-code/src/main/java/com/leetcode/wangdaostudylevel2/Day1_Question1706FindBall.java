package com.leetcode.wangdaostudylevel2;

/**
 * @author: Mr.He
 * @create: 2022-08-26 15:38
 * @description: 1706.球会落在何处
 **/
public class Day1_Question1706FindBall {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int [] res = new int[n];

        for (int i = 0; i < n; i++) {
            int col = i;
            for (int [] row : grid){
                int dir = row[col];
                col += dir;
                if (col <0 || col == n || row[col] != dir){
                    col = -1;
                    break;
                }
            }
            res[i] = col;
        }
        return res;
    }
}
