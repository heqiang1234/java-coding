package com.leetcode.Algorithm.sjjg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-04-26 22:29
 * @description: 350. 两个数组的交集 II
 **/
public class Question350Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);

            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) >= 1) {
                map.put(nums2[i], map.getOrDefault(nums2[i], 0) - 1);
                res.add(nums2[i]);
            }
        }
        int[] numss = new int[res.size()];
        for (int i = 0; i < numss.length; i++) {
            numss[i] = res.get(i);
        }
        return numss;
    }

    public static void main(String[] args) {
        intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
    }

}
