package com.leetcode.jianzhioffer;

import java.util.Arrays;

/**
 * @author heqiang
 * @date 2021/11/30 14:37
 *
 * @desc 剑指 Offer 47. 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *  
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question47MaxValue {

    public static int maxValue(int[][] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //这样会不会局部？可能会导致出现一些遗漏的很大得值
        //定义一个二维数组记录下来遍历过的值，避免重复计算
        int len = nums.length;
        int wight = nums[0].length;
        int[][] write = new int[len][wight];
        for (int i = 0; i < len ; i++) {
            Arrays.fill(write[i], 0);
        }
        int leftMaxtValue = 0;
        int rightMaxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                //maxValue = Math.max(maxValue + nums[i + 1][j], maxValue + nums[i][j + 1]);
                leftMaxtValue = 0;
                rightMaxValue = 0;
                //取左边的值
                if (i - 1 >= 0) {
                    leftMaxtValue = write[i - 1][j];
                }
                //取上面的值
                if (j - 1 >= 0) {
                    rightMaxValue = write[i][j - 1];
                }
                //将左上方和上方的最大值赋值给该位置，这样后面可以直接获取。
                write[i][j] = Math.max(leftMaxtValue, rightMaxValue) + nums[i][j];
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums[i].length; j++) {
//                System.out.print(write[i][j] + " ");
//            }
//            System.out.println();
//        }
        return write[len - 1][wight - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(nums));
    }
}
