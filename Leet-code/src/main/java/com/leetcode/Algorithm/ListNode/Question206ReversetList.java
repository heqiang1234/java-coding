package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

import java.util.List;

/**
 * @program: java-coding
 * @description: 206. 反转链表
 * @author: Mr.He
 * @create: 2022-04-13 19:12
 **/
public class Question206ReversetList {

    public static ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1);
        while (head != null){
            ListNode temp = head.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode res = new ListNode(-1, new ListNode(1,new ListNode(2)));
        reverseList(res.next);
    }

}
