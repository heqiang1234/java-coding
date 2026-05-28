package com.leetcode.specialProblem.daimasuixianglu;

/**
 * @author: Mr.He
 * @create: 2022-06-22 17:08
 * @description: 997.有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question997SortedSquares {

    public static int[] sortedSquares(int[] nums) {
        return nums;
    }

    public static void main(String[] args) {
        sortedSquares(new int[]{-4,-1,0,3,10});
        sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }

}
