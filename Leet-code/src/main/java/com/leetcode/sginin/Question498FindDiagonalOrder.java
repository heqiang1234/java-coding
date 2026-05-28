package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 498.对角线遍历
 * @date 2022-06-14 22:42:40
 */
public class Question498FindDiagonalOrder {

    public static int[] findDiagonalOrder(int[][] mat) {
        int wid = mat.length;
        int heg = mat[0].length;
        int[] res = new int[wid * heg];
        wid = wid - 1;
        heg = heg - 1;
        int x = 0, y = 0, count = 0;
        Boolean tureFlow = true; // true是向上，flae向下
        while (x <= wid || y <= heg) {
            if (jug(x, y, wid, heg)){
                res[count++] = mat[x][y];
            }
            if (tureFlow) {
                //先往右上走
                if (jug(x - 1, y + 1, wid, heg)) {
                    x--;
                    y++;
                } else {
                    if (x - 1 < 0 && y + 1 <= heg) {
                        y++;
                    } else {
                        x--;
                    }
                    tureFlow = false;
                }
            } else {
                //往左下走
                if (jug(x + 1, y - 1, wid, heg)) {
                    x++;
                    y--;
                } else {
                    if (x + 1 > wid && y - 1 >= 0) {
                        y--;
                    } else {
                        x++;
                    }
                    tureFlow = true;
                }
            }

        }
        return res;
    }

    public static Boolean jug(int x, int y, int m, int n) {
        if (x >= 0 && y >= 0 && x <= m && y <= n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

}
