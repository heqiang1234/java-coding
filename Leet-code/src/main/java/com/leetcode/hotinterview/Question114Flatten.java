package com.leetcode.hotinterview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: demo
 * @description: 114. 二叉树展开为链表
 * @author: Mr.He
 * @create: 2022-01-20 19:09
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question114Flatten {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(TreeNode left, int val, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> list;

    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        dfsTree(root);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1),curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void dfsTree(TreeNode node){
        if (node != null){
            list.add(node);
            dfsTree(node.left);
            dfsTree(node.right);
        }


    }



}
