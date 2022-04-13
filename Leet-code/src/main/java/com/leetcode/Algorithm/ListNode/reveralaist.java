package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: sd
 * @date 2022-04-13 22:08:51
 */
public class reveralaist {

    public static ListNode ReversList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null){
            ListNode next = curr.next; //将下一个记录下来
            curr.next = prev; //将当前的节点下一个节点指向前一个节点
            prev = curr; //将当前节点指向上一个节点
            curr = next; //将之前记录的下一个节点记录下来，
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode res = new ListNode(-1, new ListNode(1,new ListNode(2, new ListNode(3))));
        ReversList(res.next);
    }

}
