package com.leetcode.all;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: demo
 * @description: 653. 两数之和 IV - 输入 BST
 * @author: Mr.He
 * @create: 2022-03-21 16:54
 **/
public class Question653FindTarget {

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

   // public static Set<Integer> res = new HashSet<>();
    public static HashMap<Integer,Integer> res = new HashMap<>();

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }
        return dfs(root,k);
    }

    public static Boolean dfs(TreeNode root,int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode rt = queue.poll();
                if (res.containsKey(k - rt.val)){
                    return true;
                }
                res.put(rt.val,1);
                if (rt.left != null){
                    if (res.containsKey(k - rt.left.val)){
                        return true;
                    }
                    queue.add(rt.left);
                }
                if (rt.right != null){
                    if (res.containsKey(k - rt.right.val)){
                        return true;
                    }
                    queue.add(rt.right);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        TreeNode tr = new TreeNode(5);
//        TreeNode trleft = new TreeNode(3);
//        trleft.left = new TreeNode(2);
//        trleft.right = new TreeNode(4);
//        TreeNode trRight = new TreeNode(6);
//        trRight.right = new TreeNode(7);
//        tr.left = trleft;
//        tr.right = trRight;
        TreeNode tr = new TreeNode(2);
        tr.left = new TreeNode(1);
        tr.right = new TreeNode(3);

        System.out.println(findTarget(new TreeNode(1), 2));
    }

}
