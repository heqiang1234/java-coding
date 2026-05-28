package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2022-05-06 22:43
 * @description: 611. 有效三角形的个数
 * <p>
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question611TriangleNumber {

    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] == 0) {
                    continue;
                }
                int left = 0, right = j - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] + nums[j] > nums[i]){
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                // 这里使用二分查找，查找对应满足条件得值
                // for (int k = j + 1; k < len; k++) {
                //     if (nums[k] == 0){
                //         continue;
                //     }
                //     if (nums[i] + nums[j] > nums[k] && Math.abs(nums[j] - nums[i]) < nums[k]){
                //         sum++;
                //     }
                // }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{7, 0, 0, 0}));
    }

    public static int binarySearch(int[] nums, int max, int min) {
        return 0;
    }
}
