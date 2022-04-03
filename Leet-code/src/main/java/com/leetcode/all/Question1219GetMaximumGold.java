package com.leetcode.all;

/**
 * @program: demo
 * @description: 1219. 黄金矿工
 * @author: Mr.He
 * @create: 2022-02-05 16:57
 **/
public class Question1219GetMaximumGold {
    public static int res = 0;
    public static int m;
    public static int n;
    public static int[][] gridTemp;
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    //有个思路是依次从最大值开始进行DP，
    public static int getMaximumGold(int[][] grid) {
        gridTemp = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gridTemp[i][j] > 0) {
                    dfs(i, j, 0);
                }
            }
        }
        return res;
    }

    public static void dfs(int x, int y, int gold) {
        gold += gridTemp[x][y];
        res = Math.max(res, gold);

        int index = gridTemp[x][y];
        gridTemp[x][y] = 0;

        for (int i = 0; i < dirs.length; i++) {
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if (nx < m && ny < n && nx >= 0 && ny >= 0 && gridTemp[nx][ny] > 0) {
                dfs(nx, ny, gold);
            }
        }
        gridTemp[x][y] = index;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid));
    }
}
