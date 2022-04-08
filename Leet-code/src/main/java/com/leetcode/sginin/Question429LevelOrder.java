package com.leetcode.sginin;

import java.util.*;

/**
 * @program: java-coding
 * @description: 429. N 叉树的层序遍历
 * @author: Mr.He
 * @create: 2022-04-08 09:05
 **/
public class Question429LevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //bfs,使用一个队列，层级队列处理，一层一层
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //Node roo = queue.poll();
            List<Integer> rtList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node rt = queue.poll();
                rtList.add(rt.val);
                if (rt.children != null) {
                    for (Node nd : rt.children) {
                        queue.add(nd);
                    }
                }
            }
            list.add(rtList);
        }
        return list;
    }

    List<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int max;

    //dfs.深度遍历，记录下每一层的节点，汇总到map里面，最后获取返回结果
    public List<List<Integer>> levelOrder1(Node root) {
        if (root == null) {
            return ans;
        }
        dfs(root, 0);
        for (int i = 0; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    public void dfs(Node rt, int depth) {
        max = Math.max(max, depth);
        List<Integer> list = map.getOrDefault(depth, new ArrayList<>());
        list.add(rt.val);
        map.put(depth, list);
        for (Node nd : rt.children) {
            dfs(nd, depth + 1);
        }
    }

    //dfs深度遍历
    List<List<Integer>> ans1 = new ArrayList<>();
    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null){
            return ans1;
        }
        return null;
    }

}
