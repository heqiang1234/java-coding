package com.leetcode.face150;

/**
 * @author heqiang
 * @date 2025年07月16日19:19
 */
public class Question80RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return 1;
        int lastNum = nums[0];
        // 左指针位置拿来填补数字，右指针进行数据的遍历
        int leftPointer = 1, rightPointer = len - 1, count = 1;

        while (leftPointer <= rightPointer) {
            if (nums[leftPointer] == lastNum) {
                count++;
            } else {
                lastNum = nums[leftPointer];
                count = 1;
            }

            if (count > 2) {
                int tmp = nums[leftPointer]; // 储存数字
                for (int i = leftPointer; i <= rightPointer - 1; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[rightPointer] = tmp;
                rightPointer--;
            }
            else {
                leftPointer++;
            }
        }
        return leftPointer;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println(removeDuplicates(new int[]{1,1,1,}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));

    }
    /**
     * 示例 1：
     *
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5,
     * 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为
     * 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
     */

}
