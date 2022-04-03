package com.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 606. 根据二叉树创建字符串
 * @author: Mr.He
 * @create: 2022-03-19 22:11
 **/
public class Question606Tree2str {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String tree2str(TreeNode root) {
        List<Object> st = new ArrayList<>();
        dfsTree(root,st);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            str.append(st.get(i));
        }
        return str.toString();
    }
    public static void dfsTree(TreeNode root, List<Object> st){
        if (root == null){
            return;
        }
        st.add(root.val);
        st.add('(');
        dfsTree(root.left,st);
        if (st.get(st.size() - 1).equals('(') && root.right == null){
            st.remove(st.size() - 1);
        } else {
            st.add(')');
        }
        st.add('(');
        dfsTree(root.right,st);
        if (st.get(st.size() - 1).equals('(')){
            st.remove(st.size() - 1);
        } else {
            st.add(')');
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        rootLeft.left = new TreeNode(4);
        root.left = rootLeft;
        root.right = new TreeNode(3);
        System.out.println(tree2str(root));
    }
}
