package com.leetcode.sginin;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 814.二叉树剪枝
 * @date 2022-07-21 22:18:20
 */
public class Question814PruneTree {

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }


    public static void main(String[] args) {
    }


}
