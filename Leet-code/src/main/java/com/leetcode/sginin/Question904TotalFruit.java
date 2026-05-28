package com.leetcode.sginin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author heqiang
 * @date 2025年08月04日12:34
 */
public class Question904TotalFruit {

    public static int totalFruit(int[] fruits) {
        int res = 0, preFruit = -1;
        //int [] bowl = new int[]{0,0}; // 储存两个篮子的数量
        Map<Integer, Integer> bowl = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            int fruit = fruits[i];
            // 如果篮子中存在该种水果
            if (bowl.size() == 2) {
                if (bowl.containsKey(fruit)) {
                    bowl.replace(fruit, bowl.get(fruit) + 1);
                } else {
                    Iterator<Map.Entry<Integer, Integer>> iterator = bowl.entrySet().iterator();
                    int delFruit = -1;
                    while (iterator.hasNext()) {
                        Map.Entry<Integer, Integer> entry = iterator.next();
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();
                        if (key != preFruit) {
                            //bowl.remove(key);
                            delFruit = key;
                        }
                        // 处理key和value
                    }
                    bowl.remove(delFruit);
                    bowl.put(fruit, 1);
                }
            } else {
                if (bowl.containsKey(fruit)) {
                    bowl.replace(fruit, bowl.get(fruit) + 1);
                    // bowl.compute(fruit, (k, v) -> v + 1);
                } else {
                    bowl.put(fruit, 1);
                }
            }
            preFruit = fruit; // 存上一次水果类型
            res = Math.max(res, bowl.values().stream().mapToInt(Integer::intValue).sum());
        }

        return res;
    }

    public static int totalFruit1(int[] fruits) {
        int res = 0, left = 0;
        Map<Integer, Integer> bowl = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            bowl.merge(fruits[right], 1, Integer::sum);
            while (bowl.size() > 2) {
                int out = fruits[left];
                bowl.merge(out, -1, Integer::sum);
                if (bowl.get(out) == 0) {
                    bowl.remove(out);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        //  System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }

}
