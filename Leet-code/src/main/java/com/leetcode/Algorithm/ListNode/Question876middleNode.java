package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

public class Question876middleNode {

    public static ListNode middleNode(ListNode head) {
        // 快慢指针，快指针，一次走两步
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        middleNode(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6)))))));
    }

}
