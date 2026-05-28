package com.leetcode.sginin;

/**
 * 419. 甲板上的战舰
 */
public class Question419CountBattleships {

    public static int countBattleships(char[][] board) {
        int res = 0, m = board.length - 1, n = board[0].length - 1;
        int tempI = 0,tempJ = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'X') {//表示触碰到战舰了，此时需要将战舰的X全部改成'.'
                    tempI = i;
                    tempJ = j;
                    res++;
                    board[i][j] = '.';
                    //将这艘战舰的，其他X改为'.'
                    //如果战舰是竖着的，则遍历完全，全部置为"."
                    while (tempJ + 1 <= n && board[i][tempJ + 1] == 'X'){
                        tempJ= tempJ+ 1;
                        if (board[i][tempJ] == 'X'){
                            board[i][tempJ] = '.';
                        }
                    }

                    //如果战舰是横着的，则遍历完全，全部置为"."
                    while (tempI + 1 <= m && board[tempI + 1][j]== 'X'){
                        tempI= tempI+ 1;
                        if (board[tempI][j] == 'X'){
                            board[tempI][j] = '.';
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}});
    }
}
