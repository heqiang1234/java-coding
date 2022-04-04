package com.leetcode.Algorithm.ListNode;

/**
 * @program: java-coding
 * @description: 237. 删除链表中的节点
 * @author: Mr.He
 * @create: 2022-04-04 14:34
 **/
public class Question237DeleteNode {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public void deleteNode(ListNode node) {
        node = node.next;
        node.next.next = node.next;
    }
}
