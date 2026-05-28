package com.leetcode.year2026;

/**
 * @author heqiang
 * @date 2026年01月01日13:33
 */
public class Question840NumMagicSquaresInside {

    public static int numMagicSquaresInside(int[][] grid) {
        int row = grid[0].length - 1;
        int col = grid.length - 1;
        int count = 0;
        int ct = 0;
        // 因为是3X3，所以只需要选择中间的点不同即可
        for (int i = 1; i <= col - 1; i++) {
            for (int j = 1; j <= row - 1; j++) {
                if (grid[i][j] + grid[i - 1][j - 1] + grid[i + 1][j + 1] == 15 // 左上-左下 1
                        && grid[i][j] + grid[i + 1][j - 1] + grid[i - 1][j + 1] == 15 // 右上 - 右下 1

                        && grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] == 15 // 第一行
                        && grid[i][j] + grid[i][j - 1] + grid[i][j + 1] == 15 // 第二行
                        && grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1] == 15 // 第三行

                        && grid[i - 1][j] + grid[i][j] + grid[i + 1][j] == 15 // 第二列
                        && grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1] == 15 // 第二列
                        && grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1] == 15 // 第三列
                ) {
                    if ((grid[i][j] + grid[i - 1][j] + grid[i + 1][j]
                            + grid[i][j - 1] + grid[i][j] + grid[i][j + 1] +
                            grid[i][j + 1] + grid[i - 1][j - 1] + grid[i - 1][j] == 45)
                            //&&

                    ) {
                        count++;
                    }

                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // numMagicSquaresInside(new int[][]{{4, 7,8}, {9, 5, 1}, {2, 3, 6}});
        numMagicSquaresInside(new int[][]{{5, 5, 5}, {5, 5, 5}, {5, 5, 5}});

    }

}
