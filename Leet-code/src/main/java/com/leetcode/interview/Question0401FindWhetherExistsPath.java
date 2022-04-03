package com.leetcode.interview;

import java.util.*;

/**
 * @program: demo
 * @description: 面试题 04.01. 节点间通路
 * @author: Mr.He
 * @create: 2021-12-10 14:58
 **/
public class Question0401FindWhetherExistsPath {

    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //通过Map，构建图的邻接表。key存储每个节点，value存储该节点能到达的其他节点
        Map<Integer, List<Integer>> map = new HashMap<>();
        //将数据添加到map表内
        //这边构建最为重要
        for (int[] nums : graph) {
            if (!map.containsKey(nums[0])) {
                map.put(nums[0], new ArrayList<>());
            }
            map.get(nums[0]).add(nums[1]);
        }
        return bfs(n, map, start, target);
    }

    public static boolean bfs(int n, Map<Integer, List<Integer>> map, int start, int end) {
        //定义一个队列，来一层一层的存储节点来遍历
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);

        //定义一个bool数组，来避免重复节点
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while (!queue.isEmpty()) {
            List<Integer> list = map.get(queue.pop());
            if( list == null) {
                continue;
            }
            //遍历节点，来判断是否存在
            for (int num : list) {
                if (num == end) {
                    return true;
                }
                if (visited[num] == true){
                    continue;
                }
                visited[num] = true;
                queue.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1}, {0, 2}, {1, 2}, {1, 2}};
        System.out.println(findWhetherExistsPath(3,graph,0,2));
    }

}
