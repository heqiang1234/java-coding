package com.leetcode.Algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 94. 二叉树的中序遍历
 * @author: Mr.He
 * @create: 2022-01-11 16:37
 **/
public class Question94InorderTraversal {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfsTree(root);
        return res;
    }

    public void dfsTree(TreeNode root){
        if (root == null){
            return;
        }
        dfsTree(root.left);
        res.add(root.val);
        dfsTree(root.right);
        return;
    }
}
