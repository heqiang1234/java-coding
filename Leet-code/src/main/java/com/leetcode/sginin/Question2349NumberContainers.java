package com.leetcode.sginin;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Question2349NumberContainers {

    Map<Integer, Integer> indexToNumber;
    Map<Integer, TreeSet<Integer>> numberToIndices;

    public Question2349NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer oldNumber = indexToNumber.get(index);
        if (oldNumber != null) {
            // 移除旧数据
            numberToIndices.get(oldNumber).remove(index);
        }

        // 添加新数据
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, A -> new TreeSet<>()).add(index);

    }

    public int find(int number) {
        TreeSet<Integer> indices = numberToIndices.get(number);
        return indices == null || indices.isEmpty() ? -1 : indices.first();
    }
}
