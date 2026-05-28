package com.leetcode.Algorithm.TwoOrderSearch;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 222. 完全二叉树的节点个数
 * @date 2022-07-02 23:23:14
 */
public class Question222_1CountNodes {

    public int count = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        count++;
        dfs(root.left);
        dfs(root.right);
    }

}
