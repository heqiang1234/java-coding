package com.leetcode.Algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-coding
 * @description: 107. 二叉树的层序遍历 II
 * @author: Mr.He
 * @create: 2022-04-09 16:12
 **/
public class Question107LevelOrderBottom {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res1 = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, 0);
        //直接使用额外的空间
        for (int i = res.size() - 1; i >= 0; i--) {
            res1.add(res.get(i));
        }
        //反转
        int len = res.size();
        for (int i = 0,j = len - 1; i < j ; i++,j--) {
            List<Integer> tem = res.get(i);
            res.set(i, res.get(j));
            res.set(j,tem);
        }
        return res;
    }

    public static void dfs(TreeNode rn, int depth) {
        if (rn == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(new ArrayList<>());
        }
        List<Integer> ans = res.get(depth);
        ans.add(rn.val);
        dfs(rn.left, depth + 1);
        dfs(rn.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        levelOrderBottom(root);
    }


}
