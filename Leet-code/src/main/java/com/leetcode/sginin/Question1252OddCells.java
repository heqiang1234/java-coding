package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1252.奇数值单元格的个数
 * @date 2022-07-12 22:12:14
 */
public class Question1252OddCells {

    public static int oddCells(int m, int n, int[][] indices) {
        int len = indices.length;
        int [] rows = new int[m];
        int [] cols = new int[n];

        for(int[] ind : indices){
            rows[ind[0]]++;
            cols[ind[1]]++;
        }
        int odx = 0,ody = 0;
        for (int i = 0; i < m; i++) {
            if ((rows[i] & 1) != 0){
                odx++;
            }
        }

        for (int i = 0; i < n; i++) {
            if ((cols[i] & 1) != 0){
                ody++;
            }
        }

        return odx * (n - ody) + ody * (m - odx);
    }

    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }

}
