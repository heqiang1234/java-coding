package com.leetcode.sginin;

/**
 * @author heqiang
 * @date 2025年04月26日13:56
 */
public class Quesiton2444CountSubarrays {

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int len = nums.length;
        if (len == 0) return 0;

        int res = 0, leftIndex = 0, rightIndex = 0, minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
        while (leftIndex < len) {
            // 当数组中的值在 minK <= NUMS <= maxK
            // rightIndex的值是当前索引的值，leftIndex作为坐标

            // 下一次循环，再次判断此时数字区间的最大最小的值
            minNum = Math.min(minNum, nums[rightIndex]);
            maxNum = Math.max(maxNum, nums[rightIndex]);

            // 记录此时数字区间内，数字最大和最小的值，如果符合，则次数加一
            if (minNum == minK && maxNum == maxK) {
                res++;
            }


            //  右侧遍历字段不符合条件
            if (nums[rightIndex] < minK || nums[rightIndex] > maxK) {
                leftIndex ++;
                minNum = Integer.MAX_VALUE;
                maxNum = Integer.MIN_VALUE;
            }

            rightIndex++;


            if (rightIndex > len - 1) {
                leftIndex++;
                rightIndex = leftIndex;
                minNum = Integer.MAX_VALUE;
                maxNum = Integer.MIN_VALUE;
            }

        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));
//        System.out.println(countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));
//        System.out.println(countSubarrays(new int[]{4, 3}, 3, 3));
//        System.out.println(countSubarrays(new int[]{35054, 398719, 945315, 945315, 820417,
//                        945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913},
//                35054, 945315));
        System.out.println(countSubarrays(new int[]{928799, 888361, 928799, 928799, 928799, 928799,
                        124173, 93094, 399240, 946505, 93094, 93094, 585816},
                93094, 928799));
    }
}
