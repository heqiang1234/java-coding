package com.leetcode.year2023.signin;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2363 合并相似的物品
 * @date 2023-02-28 22:01:30
 */
public class Question2363MergeSimilarItems {

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<Integer> dx = new ArrayList<>();//储存价值
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < items1.length; i++) {
            int temp = items1[i][0];
            map.put(temp,items1[i][1]);
            if (dx.isEmpty() || !dx.contains(temp)){
                dx.add(temp);
            }
        }
        for (int i = 0; i < items2.length; i++) {
            int temp = items2[i][0];
            if (map.containsKey(temp)){
                map.put(temp,map.getOrDefault(temp,0) + items2[i][1]);
            } else {
                map.put(temp,items2[i][1]);
            }
            if (dx.isEmpty() || !dx.contains(temp)){
                dx.add(temp);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (map.containsKey(i)){
                List<Integer> tem = new ArrayList<>();
                tem.add(i);
                tem.add(map.get(i).intValue());
                res.add(tem);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        mergeSimilarItems(new int[][]{{1,1},{4,5},{3,8}}, new int[][]{{3,1},{1,5}});
    }

}
