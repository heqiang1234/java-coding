package com.leetcode.year2023.signin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 2477. 到达首都的最少油耗
 * @date 2023-12-06 21:04:22
 */
public class Question2477MinimumFuelCost {

    public static long res;

    public static long minimumFuelCost(int[][] roads, int seats) {
        res = 0;
        int n = roads.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1];
            g[x].add(y); //记录每个点的另据
            g[y].add(x);
        }
        dfs(0, -1, g, seats);
        return res;
    }

    public static int dfs(int x, int fa, List<Integer>[] g, int seats) {
        int size = 1;
        for (int y : g[x]) {
            if (y != fa) { //递归子节点，不能递归父节点。
                size += dfs(y, x, g, seats); //统计子树大小
            }
        }
        if (x > 0) { //x 不是根节点
            res += (size - 1) / seats + 1;//ceil(size/seats)
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));
    }
}
