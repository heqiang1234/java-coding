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
        ListNode lastHead = new ListNode(0, list1);
        ListNode pre = lastHead, cur = list1;
        for (int i = 0; i < a; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        //pre  头
        ListNode nxt = cur.next;
        for (int i = 0; i < b - a; i++) {
            nxt = nxt.next;
        }
        cur = list2;
        //nxt 尾巴
        while (cur.next != null) cur = cur.next;
        pre.next = list2;
        cur.next = nxt;
        return lastHead.next;
    }

}
