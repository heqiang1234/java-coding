package com.leetcode.sginin;

import java.util.*;

/**
 * @program: java-coding
 * @description: 380. O(1) 时间插入、删除和获取随机元素
 * @author: Mr.He
 * @create: 2022-04-13 10:15
 **/
public class Question380RandomizedSet {

    Map<Integer, Integer> map;
    int[] nums;
    int size;

    public Question380RandomizedSet() {
        map = new HashMap<>();
        nums = new int[200010];
        size = -1;
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            nums[++size] = val;
            map.put(val, size);
            return true;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int num = map.remove(val);
            if (num != size) map.put(nums[size], num);
            nums[num] = nums[size--];
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return nums[new Random().nextInt(size + 1)];
    }

    public static void main(String[] args) {
        Question380RandomizedSet randomizedSet = new Question380RandomizedSet();
        randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
    }
}
