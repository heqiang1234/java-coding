package com.leetcode.year2026;

import java.util.HashMap;
import java.util.Map;

/**
 * @author heqiang
 * @date 2026年05月30日17:42
 */
public class Q560subarraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[0]; // 计算出前缀和
        }

        for (int i = 0; i < n; i++) {
            // 然后再次遍历下这个数据
            res += map.getOrDefault(sum[i + 1] - k, 0);
            map.merge(sum[i + 1], 1, Integer::sum);
        }

        return res;
    }
}
