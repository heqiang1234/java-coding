package com.leetcode.hotinterview;

/**
 * @program: demo
 * @description: 96. 不同的二叉搜索树
 * @author: Mr.He
 * @create: 2022-01-23 18:52
 **/
public class Question96NumsTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public int numTrees(int n) {
        return 0;
    }
}
