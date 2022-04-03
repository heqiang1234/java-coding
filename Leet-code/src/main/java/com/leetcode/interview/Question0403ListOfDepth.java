package com.leetcode.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demo
 * @description: 面试题 04.03. 特定深度节点链表
 * @author: Mr.He
 * @create: 2021-12-13 16:42
 **/
public class Question0403ListOfDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        //为空，返回
        if (tree == null) {
            return null;
        }
        //定义一个队列，可以一层一层的存储节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        List<ListNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            ListNode listNode = new ListNode(0);
            ListNode temListNode = listNode;
            //这里最关键，将节点一层一层的遍历，从size -> 0.
            for (int i = queue.size(); i > 0; i--) {
                TreeNode temp = queue.poll();
                ListNode tempNode = new ListNode(temp.val);
                temListNode.next = tempNode;
                temListNode = temListNode.next;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(listNode);
        }
        ListNode[] listNodes = new ListNode[list.size()];
        int i = 0;
        for (ListNode l : list) {
            listNodes[i++] =l;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(8);
        TreeNode node1 = new TreeNode(3);
        node1.right = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        node2.left = node;
        node2.right = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        root.left = node2;
        root.right = node1;
        ListNode[] res = listOfDepth(root);
        for (ListNode r: res) {
            System.out.println(r);
        }
    }


}
