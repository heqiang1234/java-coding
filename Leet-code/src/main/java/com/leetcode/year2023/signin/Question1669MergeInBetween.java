package com.leetcode.year2023.signin;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1669. 合并两个链表
 * @date 2023-01-30 20:14:51
 */
public class Question1669MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //找到断掉的头和尾，然后拼接
        ListNode lastHead = null;
        ListNode head = new ListNode(0);
        head.next = list1;
        while (head.next != null) {
            if (head.next.val == a) {
                head.next = null;
            } else if (head.next.val == b) {

            }
            head.next = head;
        }
    }

}
