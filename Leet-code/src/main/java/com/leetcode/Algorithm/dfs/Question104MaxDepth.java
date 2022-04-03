package com.leetcode.Algorithm.dfs;

/**
 * @program: demo
 * @description: 104. 最大深度
 * @author: Mr.He
 * @create: 2022-01-17 16:33
 **/
public class Question104MaxDepth {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth = 0;

    public int MaxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = MaxDepth(root.left);
        int rightHeight = MaxDepth(root.right);


        return Math.min(leftHeight,rightHeight) + 1;
    }
}
