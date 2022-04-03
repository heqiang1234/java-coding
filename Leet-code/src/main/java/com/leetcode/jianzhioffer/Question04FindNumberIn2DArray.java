package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/13 19:49
 * @desc 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question04FindNumberIn2DArray {

    //直接遍历
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        int wid = 0, hig = matrix[0].length - 1;
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0) {
            return false;
        }
        while (hig >= 0 && wid < matrix.length) {
            if (matrix[wid][hig] == target) {
                return true;
            }else if (matrix[wid][hig] > target) {
                hig--;
            }
            else {
                wid++;
            }
        }
        return false;
    }

    //dfs搜索
    public boolean dfs(int[][] num, int i, int j,int target) {
        if(num.length == 0 || num == null || num[0].length == 0) {
            return false;
        }
        if(num[i][j] == target) {
            return true;
        }
//        dfs(num,i,j,target);
//        dfs(num,i,j,target);
//        dfs(num,i,j,target);
//        dfs(num,i,j,target);
        return false;
    }


    public static void main(String[] args) {
//        int[][] matrix = {{1,   4,  7, 11, 15},
//                          {2,   5,  8, 12, 19},
//                          {3,   6,  9, 16, 22},
//                          {10, 13, 14, 17, 24},
//                          {18, 21, 23, 26, 30}};
        int[][] matrix = {{-1,3}};
        int target = 5;
        System.out.println(findNumberIn2DArray(matrix, 3));
    }
}
