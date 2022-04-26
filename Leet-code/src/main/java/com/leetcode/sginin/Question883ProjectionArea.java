package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-04-26 20:31
 * @description: 883.三维形体投影面积
 **/
public class Question883ProjectionArea {

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;

    }
}

/**
 *
 作者：LeetCode-Solution
 链接：https://leetcode-cn.com/problems/projection-area-of-3d-shapes/solution/san-wei-xing-ti-tou-ying-mian-ji-by-leet-d66y/
 来源：力扣（LeetCode）
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
