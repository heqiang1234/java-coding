package com.leetcode.year2023.dfs;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 110.是否是平衡树
 * @date 2023-02-12 15:48:10
 */
public class Question110IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftH = depthTree(root.left);
        int rightH = depthTree(root.right);
        if (Math.abs(leftH - rightH) >= 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depthTree(TreeNode rt) {
        if (rt == null) {
            return 0;
        }
        int leftDepth = depthTree(rt.left);
        int rightDepth = depthTree(rt.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode rt) {
        if (rt == null) {
            return 0;
        }
        int left = dfs(rt.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(rt.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
