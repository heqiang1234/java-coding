package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 24. 两两交换链表中的节点
 * @date 2022-04-13 22:52:08
 */
public class Question24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = null;

        ListNode lenNode = head;
        int count = 0;
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode curr = res;
        while (curr != null) {
            ListNode nextNext = curr.next.next; //保存之后的节点
            ListNode next = curr.next;

            curr.next = nextNext;
            next.next = nextNext.next;
            nextNext.next = next;
            curr = next;
        }
        return res.next;
    }
}
