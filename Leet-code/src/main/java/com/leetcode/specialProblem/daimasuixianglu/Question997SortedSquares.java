package com.leetcode.specialProblem.daimasuixianglu;

/**
 * @author: Mr.He
 * @create: 2022-06-22 17:08
 * @description: 997.有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question997SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int countFu = 0;//统计负数
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0){
                countFu++;
            } else {
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            nums[i] = temp * temp;
        }

        if (countFu > 0){

        } else {
            return nums;
        }
    }

}
