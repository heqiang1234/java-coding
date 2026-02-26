package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(-1);
        ListNode res = tmp;
        int numIn = 0;

        while ((l1 != null || l2 != null) || numIn != 0) {
            int currentNumL1 = 0;
            int currentNumL2 = 0;

            if (l1 != null) {
                currentNumL1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                currentNumL2 = l2.val;
                l2 = l2.next;
            }
            int nowNum = (currentNumL1 + currentNumL2 + numIn);

            numIn = nowNum / 10;

            nowNum = nowNum % 10;
            tmp.next = new ListNode(nowNum);

            tmp = tmp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {

    }

}
