package com.leetcode.year2023.dfs;

import com.leetcode.model.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author HQ
 * @program: java-coding
 * @description: 111.二叉树的最小深度
 * @date 2023-02-12 16:48:17
 */
public class Question111MinDepth {

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode rt) {
        if (rt == null) {
            return 0;
        }
        if (rt.left == null && rt.right == null){
            return 1;
        }
        int ans = Integer.MAX_VALUE;
        if (rt.left != null){
            ans = Math.min(dfs(rt.left),ans);
        }

        if (rt.right != null){
            ans = Math.min(dfs(rt.right),ans);
        }
        return ans + 1;
    }
}
