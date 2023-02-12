package com.leetcode.year2023.dfs;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 99. 恢复二叉搜索树
 * @date 2023-02-09 21:56:56
 */
public class Question99RecoverTree {

    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        dfsTree(root);
        if (x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }

    //中序遍历 1，3，2，4   使用 x,y储存3，2
    public void dfsTree(TreeNode rt){
        if (rt == null)
            return;
        dfsTree(rt.left);
        if (pre != null){
            pre = rt;
        } else {
            if (pre.val > rt.val){
                y = rt;
                if (x == null){
                    x = pre;
                }
            }
        }
        dfsTree(rt.right);
    }

}
