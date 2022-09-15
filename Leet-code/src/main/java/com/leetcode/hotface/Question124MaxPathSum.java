package com.leetcode.hotface;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 124.二叉树的最大路径和
 * @date 2022-09-15 23:48:53
 */
public class Question124MaxPathSum {

    public int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = 0;
        dpsTree(root);
        return maxValue;
    }

    public int dpsTree(TreeNode rt){

        if (rt == null){
            return 0;
        }
        int left = Math.max(0,dpsTree(rt.left));
        int right = Math.max(0,dpsTree(rt.right));

        maxValue = Math.max(maxValue,left + right + rt.val);

        return Math.max(left,right) + rt.val;

    }

}
