package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 206. 反转链表
 * @date 2022-10-14 22:22:47
 */
public class Day03_206ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
