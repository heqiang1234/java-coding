package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-05-05 14:31
 * @description: 713.乘积比K小的子数组
 **/
public class Question713NumSubarrayProductLessThanK {

    /**
     * 输入：nums = [10,5,2,6], k = 100
     * 输出：8
     * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    //超时
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int sum = 0;
        int totalNum = 1;

        while (totalNum <= nums.length) {
            for (int i = 0; i < nums.length; i++) {
                int tempSum = 1, arryCount = 0;
                for (int j = i; j < nums.length && j < i + totalNum; j++) {
                    tempSum = tempSum * nums[j];
                    if (tempSum >= k) {
                        break;
                    }
                    arryCount++;
                }
                if (tempSum < k && arryCount == totalNum) {
                    sum += 1;
                }
            }
            totalNum++;
        }
        return sum;
    }

    //1
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = 1, right = i;
            while (count < k && right < len) {
                count = count * nums[right];
                if (count < k) {
                    right++;
                    sum++;
                }
            }
        }
        return sum;
    }

    //2
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int len = nums.length;
        for (int i = 0, j = 0, curr = 1; i < len; i++) {
            curr *= nums[i];
            while (curr >= k) {
                curr /= nums[j++];
            }
            sum += i - j + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK2(new int[]{10,5,2,6
        }, 100));
    }
}
