package com.leetcode.sginin;

/**
 * @author HQ
 * @program: java-coding
 * @description: 287, 重复的元素
 * @date 2022-07-04 22:01:40
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question287_1FindDuplicate {

    //1常量级
    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            for (int num: nums){
                if (num <= mid){
                    count++;
                }
            }

            if (count > mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
