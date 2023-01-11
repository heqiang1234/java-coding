package com.leetcode.daimasuixianglu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Mr.He
 * @create: 2022-10-17 15:40
 * @description: 349. 两个数组的交集
 **/
public class Day06_349Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {//生成第一个set
            set.add(num);
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num: nums2) {//如果存在，则放入第二个set,
            if (set.contains(num)){
                set1.add(num);
            }
        }
        int [] res = new int[set1.size()];
        int i = 0;
        //将得到的set放入数组，返回结果
        for (Integer num: set1) {
            res[i++] = num;
        }
        return res;
    }

}
