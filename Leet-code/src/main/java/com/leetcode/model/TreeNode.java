package com.leetcode.model;

/**
 * @program: java-coding
 * @description: 链表的model类
 * @author: Mr.He
 * @create: 2022-04-09 16:59
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
