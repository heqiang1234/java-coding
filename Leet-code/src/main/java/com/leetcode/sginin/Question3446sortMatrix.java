package com.leetcode.sginin;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heqiang
 * @date 2025年08月28日10:29
 */
public class Question3446sortMatrix {

    public static int[][] sortMatrix(int[][] grid) {
        // 1. 获取到所有的斜线
        // 1.1 斜线的规律是怎么样的？ 
        //      由边做起点（i，0），（0，j）, 然后（i + 1, 0 + 1）(0 + 1, j + 1)
        int n = grid.length;
        int[][] resGrid = new int[n][n];
        // 左下角（i，0）-》（i+1，0+1）
        for (int i = 0; i < n; i++) {
            // 获取到数据数字，然后排序
            Integer[] tmp = sortNumRe(i, 0, grid,0);
            // 排序后的数字，写进去数组(i,0)
            int indexX = i, indexJ = 0;
            for (int j = 0; j < n - i; j++) {
                resGrid[indexX++][indexJ++] = tmp[j];
            }
        }
        // 右上角 （0，j）
        for (int i = 1; i < n; i++) {
              // 获取到数据数字，然后排序
            Integer[] tmp = sortNumRe(0, i, grid,1);
            // 排序后的数字，写进去数组(i,0)
            int indexX = 0, indexJ = i;
            for (int j = 0; j < n - i; j++) {
                resGrid[indexX++][indexJ++] = tmp[j];
            }
        }
        // 2. 获取到斜线的数字

        // 3. 重新排列斜线上的数字，然后放到对应的位置

        // 4. 返回处理之后的数组，可以考虑使用新数组和老数组
        return resGrid;
    }

    // 返回一个排序好的数组
    public static Integer[] sortNumRe(int x, int y, int[][] grid,int actionIn) {
        List<Integer> tmpList = new ArrayList<>();
        int n = grid.length - 1;
        for (int i = 0; i <= n; i++) {
            if (x <= n && y <= n && x >= 0 && y >= 0){
                tmpList.add(grid[x][y]);
            }
            x++;y++;
        }
        if (actionIn == 0){ // 降序
            tmpList.sort((a, b) -> Integer.compare(b,a));
            return tmpList.stream().toArray(Integer[]::new);
        }else { // 升序
            //return Collections.sort(tmpList);
            tmpList.sort((a, b) -> Integer.compare(a,b));

        }
        return tmpList.stream().toArray(Integer[]::new);
    }


    public static void main(String[] args) {
        sortMatrix(new int[][]{{1,7,3},{9,8,2},{4,5,6}});
    }

}
