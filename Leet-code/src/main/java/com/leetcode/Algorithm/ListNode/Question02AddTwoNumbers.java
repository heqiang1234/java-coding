package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

public class Question02AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1);
        ListNode res = tmp;
        int numIn = 0; // 表示是否进位。
        while ((l1 != null || l2 != null) || numIn != 0 ) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            int tmpVal = l1Val + l2Val + numIn;

            numIn = tmpVal / 10; // 下一次是否需要

            tmpVal = tmpVal % 10;

            tmp.next = new ListNode(tmpVal);
            tmp = tmp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = (new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = (new ListNode(5, new ListNode(6, new ListNode(4))));
        addTwoNumbers(l1,l2);
    }

}
