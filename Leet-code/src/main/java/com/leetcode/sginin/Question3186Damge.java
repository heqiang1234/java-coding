package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heqiang
 * @date 2025年10月11日8:44
 */
public class Question3186Damge {
    /**
     * 一个魔法师有许多不同的咒语。
     * <p>
     * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
     * <p>
     * 已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
     * <p>
     * 每个咒语最多只能被使用 一次 。
     * <p>
     * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：power = [1,1,3,4]
     * <p>
     * 输出：6
     * <p>
     * 解释：
     * <p>
     * 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
     * <p>
     * 示例 2：
     * <p>
     * 输入：power = [7,1,6,6]
     * <p>
     * 输出：13
     * <p>
     * 解释：
     * <p>
     * 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= power.length <= 105
     * 1 <= power[i] <= 109
     */

    public static long maximumTotalDamage(int[] power) {
        long res = 0;
        int len = power.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = power[i];
            if (map.containsKey(num)) continue;

            map.compute(num, (k, v) -> v == null ? num : v + num);
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (!(power[j] == power[i] - 2
                        || power[j] == power[i] - 1
                        || power[j] == power[i] + 1
                        || power[j] == power[i] + 2)) {
                    int mm = power[j];
                    map.compute(num, (k, v) -> v == null ? mm : v + mm);
                }
            }
            res = Math.max(res, map.get(num));
        }
        return res;
    }

    public static void main(String[] args) {
        maximumTotalDamage(new int[]{7,1,6,6});
    }

}
