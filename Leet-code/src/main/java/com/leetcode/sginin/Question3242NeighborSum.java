package com.leetcode.sginin;

import java.util.HashMap;

public class Question3242NeighborSum {

    public static int[][] grids;
    public static int row;
    public static int col;

    public static class pair {
        Integer indexI;
        Integer indexJ;

        public pair(Integer a, Integer b) {
            this.indexI = a;
            this.indexJ = b;
            return;
        }
    }

    public static HashMap<Integer, pair> mapp = new HashMap<Integer, pair>();

    public  static void  Question3242NeighborSum1(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        grids = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grids[i][j] = grid[i][j];
                mapp.put(grid[i][j], new pair(i, j));
            }
        }
    }

    public static int adjacentSum(int value) {
        int sum = 0;
        int i = mapp.get(value).indexI;
        int j = mapp.get(value).indexJ;
        //上下左右
        //上
        if (j - 1 >= 0) {
            sum += grids[i][j - 1];
        }
        //下
        if (j + 1 < col) {
            sum += grids[i][j + 1];
        }
        //左
        if (i - 1 >= 0) {
            sum += grids[i - 1][j];
        }
        //右
        if (i + 1 < row) {
            sum += grids[i + 1][j];
        }
        return sum;
    }

    public static int diagonalSum(int value) {
        int sum = 0;
        int i = mapp.get(value).indexI;
        int j = mapp.get(value).indexJ;
        //上下左右
        //左上
        if (i - 1 >= 0 && j - 1 >= 0) {
            sum += grids[i - 1][j - 1];
        }
        //右上
        if (i + 1 < row && j - 1 >= 0) {
            sum += grids[i + 1][j - 1];
        }
        //左下
        if (i - 1 >= 0 && j + 1 < col) {
            sum += grids[i - 1][j + 1];
        }
        //右下
        if (i + 1 < row && j + 1 < col) {
            sum += grids[i + 1][j + 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        Question3242NeighborSum1(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}});
        System.out.println(adjacentSum(1));
        System.out.println(adjacentSum(4));
        System.out.println(diagonalSum(4));
        System.out.println(diagonalSum(8));
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */