package com.leetcode.sginin;

import com.leetcode.model.TreeNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1302. 层数最深叶子节点的和
 * @date 2022-08-17 22:47:32
 */
public class Question1302DeepestLeavesSum {

    //dfs
    public int sumNum = 0,maxDep = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfsNode(root,0);
        return sumNum;
    }

    public void dfsNode(TreeNode root,int dep){
        if (root == null){

            return;
        }
        dfsNode(root.left,dep + 1);
        dfsNode(root.right,dep + 1);
        if (dep > maxDep){
            maxDep = dep;
            sumNum = root.val;
        } else if (dep == maxDep){
            sumNum += root.val;
        }
    }

}
