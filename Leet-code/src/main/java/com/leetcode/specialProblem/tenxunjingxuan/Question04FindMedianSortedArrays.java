package com.leetcode.specialProblem.tenxunjingxuan;

/**
 * @author: Mr.He
 * @create: 2022-06-09 15:23
 *                     15:51
 * @description: 04.4. 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]  0,1,2
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4] 0，1，2，3
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question04FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums3 = new int[len1 + len2];
        int j = 0, k = 0, count = 0;
        for (int i = 0; i < len1 + len2; i++) {
            int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;
            num1 = j >= len1 ? Integer.MAX_VALUE : nums1[j];
            num2 = k >= len2 ? Integer.MAX_VALUE : nums2[k];
            if (num1 < num2) {
                nums3[i] = num1;
                j++;
            } else {
                nums3[i] = num2;
                k++;
            }
            count++;
        }
        int left = 0, right = count;
        if (count % 2 == 0) {
            return 1.0 * (nums3[count / 2] + nums3[count / 2 - 1]) / 2;
        } else {
            return nums3[count / 2];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
