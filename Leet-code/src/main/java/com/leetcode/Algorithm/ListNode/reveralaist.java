package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: sd
 * @date 2022-04-13 22:08:51
 */
public class reveralaist {

    public static ListNode ReversList(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode res = new ListNode(-1, new ListNode(1, new ListNode(2, new ListNode(3))));
        ReversList(res.next);
    }

    public ListNode rev(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (head != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
