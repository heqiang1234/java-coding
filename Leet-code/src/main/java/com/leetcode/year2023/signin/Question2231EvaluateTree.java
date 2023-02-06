package com.leetcode.year2023.signin;

import com.leetcode.model.TreeNode;

/**
 * @author: Mr.He
 * @create: 2023-02-06 10:55
 * @description: 2331. 计算布尔二叉树的值
 **/
public class Question2231EvaluateTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) {//左节点为空，说明为叶子节点
            return root.val == 1;//如果值为1，则说明是true
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

}
