package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author HQ
 * @program: java-coding
 * @description: 540. 有序数组中的单一元素
 * @date 2022-06-30 22:15:24
 * <p>
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * <p>
 * 请你找出并返回只出现一次的那个数。
 * <p>
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question540_1singleNonDuplicate {

    //二分，我的想法是获取到，然后左右比较，存在相同就变化，并且可以判断是在左还是在右
    public static int singleNonDuplicate(int[] nums) {
        int len = nums.length - 1;
        int res = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {
                if (mid + 1 <= len && nums[mid] == nums[mid + 1]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    res = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    res = mid;
                }
            }
        }
        return nums[res];
    }

    //经典位运算
    public static int singleNonDuplicate2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(singleNonDuplicate2(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
    }

}
