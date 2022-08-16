package com.leetcode.wangdaostudy;

import com.leetcode.model.ListNode;

import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 206. 反转链表
 * @date 2022-08-11 23:41:48
 */
public class Question03_206ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev= null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next ;
        }
        return prev;
    }

}
