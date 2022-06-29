package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 498.对角线遍历
 * @date 2022-06-14 22:42:40
 */
public class Question498FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int wid = mat.length;
        int heg = mat[0].length;
        int[] res = new int[wid * heg];
        int x = 0, y = 0;
        Boolean tureFlow = true;
        while (x <= wid || y <= heg) {
            if (tureFlow) {
                //先往左上走
                if (jug(x + 1, y + 1, wid, heg)) {
                    x++;
                    y++;
                } else {
                    if (y + 1 > wid){
                        x++;
                    } else {
                        y++;
                    }
                    tureFlow = false;
                }
            } else {
                //先往左上走
                if (jug(x - 1, y - 1, wid, heg)) {
                    x++;
                    y++;
                } else {
                    if (y - 1 > 0)
                    tureFlow = true;
                }
            }

        }
        return null;
    }

        public Boolean jug ( int x, int y, int m, int n){
            if (x >= 0 && y >= 0 && x <= m && y <= n) {
                return true;
            }
            return false;
        }

    }
