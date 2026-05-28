package com.leetcode.hotface;

import java.util.Arrays;

/**
 * @author heqiang
 * @date 2025年07月20日14:43
 */
public class Question289GameOfLife {

    public static  void gameOfLife(int[][] board) {
        int lenX = board[0].length - 1, lenJ = board.length - 1;

//        int[][] copyNums = new int[lenJ + 1][];
//
//        for (int i = 0; i <= lenJ; i++) {
//            copyNums[i] = Arrays.copyOf(board[i], board[i].length);
//        }

        int rowCount = board.length;
        int colCount = board[0].length;
        int[][] copied = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            System.arraycopy(board[i], 0, copied[i], 0, colCount);
        }

        for (int i = 0; i <= lenJ; i++) {
            for (int j = 0; j <= lenX; j++) {
                board[i][j] = Judge(copied, i, j, lenX, lenJ);
            }
        }
    }

    public  static int Judge(int[][] board, int indexX, int indexJ, int lenJ, int lenX) {
        // 判断周围8个位置，进行检查
        int countL = 0, countD = 0; // L表示活细胞.D表示死细胞
        //indexX - 1,indexJ - 1    indexX,indexJ - 1     indexX + 1,indexJ - 1
        //indexX - 1,indexJ        indexX,indexJ         indexX + 1,indexJ
        //indexX - 1,indexJ + 1    indexX,indexJ + 1     indexX + 1,indexJ + 1

        if ((indexX - 1 >= 0 && indexX - 1 <= lenX)
                && (indexJ - 1 >= 0 && indexJ - 1 <= lenJ)) {
            if (board[indexX - 1][indexJ - 1] == 0) {
                countD++;
            } else {
                countL++;
            }
        }

        if (indexX - 1 >= 0 && indexX - 1 <= lenX) {
            if (board[indexX - 1][indexJ] == 0) {
                countD++;
            } else {
                countL++;
            }
        }

        if ((indexX - 1 >= 0 && indexX - 1 <= lenX)
                && (indexJ + 1 >= 0 && indexJ + 1 <= lenJ)) {
            if (board[indexX - 1][indexJ + 1] == 0) {
                countD++;
            } else {
                countL++;
            }
        }

        if ((indexJ - 1 >= 0 && indexJ - 1 <= lenJ)) {
            if (board[indexX][indexJ - 1] == 0) {
                countD++;
            } else {
                countL++;
            }
        }
        if ((indexJ + 1 >= 0 && indexJ + 1 <= lenJ)) {
            if (board[indexX][indexJ + 1] == 0) {
                countD++;
            } else {
                countL++;
            }
        }

        if ((indexX + 1 >= 0 && indexX + 1 <= lenX)
                && (indexJ - 1 >= 0 && indexJ - 1 <= lenJ)) {
            if (board[indexX + 1][indexJ - 1] == 0) {
                countD++;
            } else {
                countL++;
            }
        }
        if ((indexX + 1 >= 0 && indexX + 1 <= lenX)) {
            if (board[indexX + 1][indexJ] == 0) {
                countD++;
            } else {
                countL++;
            }
        }

        if ((indexX + 1 >= 0 && indexX + 1 <= lenX)
                && (indexJ + 1 >= 0 && indexJ + 1 <= lenJ)) {
            if (board[indexX + 1][indexJ + 1] == 0) {
                countD++;
            } else {
                countL++;
            }
        }

        if (board[indexX][indexJ] == 0) {
            if (countL == 3) {
                return 1;
            }
        } else {

            if (countL < 2 || countL > 3) {
                return 0;
            } else {
                return 1;
            }

        }

        return board[indexX][indexJ];
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
