package com.leetcode.all;

/**
 * @program: demo
 * @description: 142. 环形链表 II
 * @author: Mr.He
 * @create: 2022-04-03 15:33
 **/
public class Question142DetectCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
       ListNode fast = head.next;
       ListNode slow = head;
       while (fast != slow){
           fast = fast.next;
           slow = slow.next;
       }
        return fast;
    }

}
