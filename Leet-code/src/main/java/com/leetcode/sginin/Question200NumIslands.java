package com.leetcode.sginin;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Question200NumIslands {


    public int numIslands(char[][] grid) {
        int res = 0;
        int col = grid.length;
        int row = grid[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                // 判断是否是岛屿，则需要判断上下左右四个方向，使用过的节点，置为vis
                if (grid[i][j] == '1'){
                    dfs(grid, i, j); // 会从当前位置出发，把所有的相邻为1的位置都置为2.则该次遍历完，就是一个岛屿。
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int r, int c) {

        // 输出的位置已经不在图内，则跳出本次遍历
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) {
            return;
        }

        // 如果已经访问过该位置，则不需要继续进行处理
        if (grid[r][c] != '1') {
            return;
        }

        grid[r][c] = 2;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

}
