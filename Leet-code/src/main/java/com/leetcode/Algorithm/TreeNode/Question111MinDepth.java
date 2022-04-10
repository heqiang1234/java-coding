package com.leetcode.Algorithm.TreeNode;

import com.leetcode.model.TreeNode;

/**
 * @program: java-coding
 * @description: 111. 二叉树的最小深度
 * @author: Mr.He
 * @create: 2022-04-09 16:58
 **/
public class Question111MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 计算左子树的深度
        int leftMinDepth = minDepth(root.left);
        // 计算右子树的深度
        int rightMinDpth = minDepth(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return Math.max(leftMinDepth,rightMinDpth) + 1;
    }

}
