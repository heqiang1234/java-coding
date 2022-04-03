package com.leetcode.interview;

import java.util.List;

/**
 * @program: demo
 * @description: 面试题 04.05. 合法二叉搜索树
 * @author: Mr.He
 * @create: 2021-12-31 14:17
 **/
public class Question0405IsValidBST {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public List<Integer> list;

    public boolean isValidBST(TreeNode root){

        if (root == null){
            return true;
        }
        dpNum(root);
        return true;
    }

    public boolean dpNum(TreeNode root) {
        if (root == null) {
            return true;
        }
        if(!dpNum(root.left)){
            return false;
        }
        if(list.size() > 0 && list.get(list.size() - 1) > root.val) {
            return false;
        }
        list.add(root.val);
        if(!dpNum(root.right)){
            return false;
        }
        return true;
    }

    public boolean highter(TreeNode root, Integer left, Integer right){
        if (root == null){
            return true;
        }
        int val = root.val;

        if(left != null && val <= left){
            return false;
        }

        if(right != null && val >= right){
            return false;
        }

        if(!highter(root.left,left,val)){
            return false;
        }

        if(!highter(root.right,val,right)){
            return false;
        }
        return true;
    }


}
