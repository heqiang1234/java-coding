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
        int countFu = 0;//统计负数
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                countFu++;
            } else {
                break;
            }
        }

        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            nums[i] = temp * temp;
        }

        if (countFu > 0) {
<<<<<<< HEAD
            int[] res = new int[len];
            int left = 0, right = len - 1;
            int index = len - 1;
            while (left <= right){
                if (nums[left] < nums[right]){
                    res[index] = nums[right];
                    index--;
                    right--;
                } else {
                    res[index] = nums[left];
                    left++;
                    index--;
=======
            len = len - 1;
            int left = 0, right = len;
            int[] res = new int[len + 1];
            while (left <= right) {
                if (nums[right] > nums[left]) {
                    res[len] = nums[right];
                    len--;
                    right--;
                } else {
                    res[len] = nums[left];
                    len--;
                    left++;
>>>>>>> ba2527421cf0c6a0b31ec653be0cb6a7f59ef779
                }
            }
            return res;
        } else {
            return nums;
        }
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        sortedSquares(new int[]{-4,-1,0,3,10});
=======
        sortedSquares(new int[]{-4, -1, 0, 3, 10});
>>>>>>> ba2527421cf0c6a0b31ec653be0cb6a7f59ef779
    }

}
