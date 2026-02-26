package com.leetcode.summerRun2024;

/**
 * @author heqiang
 * @desc 289. 生命游戏
 */
public class Question289GameOfLife {

    private static final int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        //int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 该点位的上下左右的情况
                int liveCount = 0, diedCount = 0;
                for (int k = 0; k < dirs.length; k++) {
                    int newIndexShu = i + dirs[k][0];
                    int newIndexHeng = j + dirs[k][1];
                    if (newIndexHeng >= 0
                            && newIndexHeng < col
                            && newIndexShu >= 0
                            && newIndexShu < row ) {
                        // 标记状态，0是deid,1是 live, 2是从活到死，3是死到活。
                        System.out.println(newIndexShu + " " + newIndexHeng + " : " + board[newIndexShu][newIndexHeng]);
                        if (board[newIndexShu][newIndexHeng] == 1 || board[newIndexShu][newIndexHeng] == 2) {
                            liveCount++;
                        } else {
                            diedCount++;
                        }
                    }
                }
                if (liveCount > 3 || liveCount < 2) {
                    if (board[i][j] == 1) {
                        board[i][j] = 2;
                    }
                } else if (liveCount == 3 || liveCount == 2) {
                    if (board[i][j] == 0 && liveCount == 3) {
                        board[i][j] = 3;
                    }
                } else {
                    //
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
            return;
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
