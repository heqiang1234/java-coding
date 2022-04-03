package com.leetcode.jianzhioffer;

import java.util.HashMap;

/**
 * @program: demo
 * @description: 剑指 Offer II 010. 和为 k 的子数组
 * @author: Mr.He
 * @create: 2022-03-06 18:43
 * <p>
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * <p>
 *  
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 * 示例 2 :
 * <p>
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/QTMn0o
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class QuestionII010SubarraySum {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> res = new HashMap<>();
        int sum = 0;
        int ret = 0;
        res.put(0, 1);
        for (int num : nums) {
            sum += num;
            ret += res.getOrDefault(sum - k, 0);
            res.put(sum, res.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(subarraySum(nums, 3));
    }
}
