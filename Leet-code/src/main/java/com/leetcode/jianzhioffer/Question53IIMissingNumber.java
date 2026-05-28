package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/6 17:14
 * @desc 剑指 Offer 53 - II. 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question53IIMissingNumber {

    public static int missingNumber(int[] nums) {
        int flag = 0;
        int len = nums.length;
        for (int i = 0; i < len -1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
            flag = 1;
        }
        if (flag == 1) {
           return nums[len -1] + 1;
        }
        if (nums[0] == 0 ) {
            return 1;
        }
        if (len == 1) {
            return nums[0] - 1;
        }
        return nums[0] + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(missingNumber(a));
    }
}
