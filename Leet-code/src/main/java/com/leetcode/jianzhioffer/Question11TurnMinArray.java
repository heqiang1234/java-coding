package com.leetcode.jianzhioffer;

/**
 * @author heqiang
 * @date 2021/11/19 09:56
 * @desc
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Question11TurnMinArray {

    //相当于快慢指针遍历。因为是旋转数组，顺序没有改变，所以找到一个降序的数字即可。
    public static int minAaaay(int[] numbers) {
        if (numbers.length == 0 || numbers == null) {
            return 0;
        }
        for (int i = 0,j = 1; i <numbers.length  && j < numbers.length; i++,j++) {
            if (numbers[j]<numbers[i]) {
               return numbers[j];
            }
        }
        return numbers[0];
    }

    //二分查找
    public static  int minArrayMid(int[] nums) {

        int left = 0,right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>1;
            if( nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else
            {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        System.out.println(minAaaay(numbers));
    }
}
