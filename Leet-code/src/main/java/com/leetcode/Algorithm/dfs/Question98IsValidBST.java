package com.leetcode.Algorithm.dfs;

/**
 * @program: demo
 * @description: 98.  验证二叉搜索树
 * @author: Mr.He
 * @create: 2022-01-11 16:51
 **/
public class Question98IsValidBST {
    static class  TreeNode {
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

    public static boolean isValidBST(TreeNode root) {
        return dfsTree(root, -Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public static boolean dfsTree(TreeNode root, int leftValue, int rightValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= leftValue || root.val >= rightValue) {
            return false;
        }

        return dfsTree(root.left, leftValue, root.val) && dfsTree(root.right, root.val, rightValue);
    }

    public static void main(String[] args) {

        TreeNode rootleft = new TreeNode(1);
        TreeNode rootright = new TreeNode(3);
        TreeNode root = new TreeNode(2,rootleft,rootright);
        System.out.println(isValidBST(root));
    }
}
