package com.leetcode.summerRun2024;

/**
 * @author heqiang
 * @desc 289. 生命游戏
 */
public class Question289GameOfLife {

    private final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

            }
        }
    }

    /**
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * @param board
     * @return
     */
    public boolean changeLife(int[][] board) {
        int countLive = 0;/
        int countDead = 0;

        return true;
    }

}
