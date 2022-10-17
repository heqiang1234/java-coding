package com.llabuladongstudy.zero.three;

import com.leetcode.model.ListNode;

/**
 * @author: Mr.He
 * @create: 2022-09-27 14:34
 * @description: 23. 合并K个升序链表
 **/
public class Question23MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode end = null;
        ListNode newNd = null;
        for (ListNode nd : lists) {
            newNd = megreListNode(nd, end);
            end = newNd;
        }
        return newNd;
    }


    public ListNode megreListNode(ListNode p1, ListNode p2) {
        ListNode dump = new ListNode(-1), p = dump;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
        }
        p.next = p1 == null ? p2 : p1;
        return dump.next;
    }

}
