package com.leetcode.hotinterview;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: demo
 * @description: 102. 二叉树的层序遍历
 * @author: Mr.He
 * @create: 2022-01-16 22:10
 **/
public class Question102LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.add(root);
       List<List<Integer>> res = new ArrayList<>();
        while (queue != null){
            List<Integer> tempList = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
                tempList.add(temp.val);
            }
            res.add(tempList);
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> leva = levelOrder(null);
    }
}
