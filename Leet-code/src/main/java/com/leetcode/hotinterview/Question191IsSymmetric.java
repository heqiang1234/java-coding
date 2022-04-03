package com.leetcode.hotinterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: demo
 * @description: 101. 对称二叉树
 * @author: Mr.He
 * @create: 2022-01-17 10:58
 **/
public class Question191IsSymmetric {

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

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null){
                    queue.add(treeNode.left);
                } else {
                    if (treeNode.val != Integer.MAX_VALUE){
                        queue.add(new TreeNode(Integer.MAX_VALUE));
                    }
                }

                if (treeNode.right != null){
                    queue.add(treeNode.right);
                } else {
                    if (treeNode.val != Integer.MAX_VALUE){
                        queue.add(new TreeNode(Integer.MAX_VALUE));
                    }
                }
                list.add(treeNode.val);
            }
            if (cheakStatus(list) == false) {
                return false;
            }

        }
        return true;
    }

    public static boolean cheakStatus(List<Integer> list) {
        int len  = list.size() - 1;
        for (int i = 0; i < list.size(); i++,len--) {
            if (len <= i) {
                return true;
            }
            if (!list.get(i).equals(list.get(len))){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rleft = new TreeNode(2);
        rleft.left = new TreeNode(3);
        rleft.right = new TreeNode(4);
        TreeNode rright = new TreeNode(2);
        rright.left = new TreeNode(4);
        rright.right = new TreeNode(3);
//        TreeNode root = new TreeNode(1);
//        TreeNode rleft = new TreeNode(2);
//        rleft.right = new TreeNode(3);
//        TreeNode rright = new TreeNode(2);
//        rright.right = new TreeNode(3);
        root.left = rleft;
        root.right = rright;
        System.out.println(isSymmetric(root));
    }

}
