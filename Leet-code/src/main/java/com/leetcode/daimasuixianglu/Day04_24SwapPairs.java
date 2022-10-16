package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 24. 两两交换链表中的节点
 * @date 2022-10-15 13:02:54
 */
public class Day04_24SwapPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dump = new ListNode(-1,head);
        ListNode cur = dump;
        while (cur.next != null && cur.next.next != null){
           ListNode temp = head.next.next;
           cur.next = head.next;
           head.next.next = head;
           head.next = temp;

           cur = head;
           head = head.next;
        }
        return dump.next;

    }

}
