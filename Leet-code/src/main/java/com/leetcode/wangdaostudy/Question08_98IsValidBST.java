package com.leetcode.wangdaostudy;

import com.leetcode.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author HQ
 * @program: java-coding
 * @description: 98.验证二叉搜索树
 * @date 2022-08-17 23:09:34
 */
public class Question08_98IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return false;
        }
        Deque<TreeNode> res = new ArrayDeque<>();
        res.add(root);
        int leftMax = 0;
        while (!res.isEmpty()){
            for (int i = res.size(); i > 0 ; i--) {
                TreeNode nd = res.poll();
                if (nd.left != null){
                    if (nd.val <= nd.left.val){
                        return false;
                    }
                    res.add(nd.left);
                }
                if (nd.right != null){
                    if (nd.val >= nd.right.val ){
                        return false;
                    }
                    res.add(nd.right);
                }
            }
        }
        return true;
    }

}
