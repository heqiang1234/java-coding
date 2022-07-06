package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author HQ
 * @program: java-coding
 * @description: 240. 搜索二维矩阵 II
 * @date 2022-06-29 23:07:17
 */
public class Question240SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        //首先确认位置
        int left = 0, right = matrix.length - 1;
        int rightIndex = checkNum(matrix[0], left, right, target);
        int leftIndex = 0;
        if (rightIndex == Integer.MIN_VALUE) {
            return false;
        }
        rightIndex = rightIndex == Integer.MAX_VALUE ? 0 : 1;
        if (rightIndex == Integer.MAX_VALUE) {
            leftIndex = checkNum2(matrix, left, right, target, right);
        }
        if (leftIndex == Integer.MIN_VALUE) {
            return false;
        }
        for (int i = leftIndex; i < right; i++) {

        }
        return false;

        return false;

    }

    public int checkNum(int[] num, int left, int right, int target) {
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num[mid] == target) {
                return Integer.MAX_VALUE;
            }
            if (num[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    public Boolean checkNum(int[][] num, int left, int right, int target, int iIndex) {
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num[iIndex][mid] == target) {
                return true;
            }
            if (num[iIndex][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int checkNum2(int[][] num, int left, int right, int target, int jIndex) {
        int res = Integer.MIN_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num[mid][jIndex] == target) {
                return Integer.MAX_VALUE;
            }
            if (num[mid][jIndex] > target) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

}
