package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

import java.util.List;
import java.util.Objects;

/**
 * @author heqiang
 * @date 2025年08月23日10:03
 */
public class Question445addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Tmp = l1;
        ListNode l2Tmp = l2;
        ListNode res = new ListNode(-1);
        ListNode res1 = res;
        int len1 = 0, len2 = 0; // len = l1.len - l2.len ,负数则l2 > l1 ,正数则L1 > l2
        int numIn = 0, l1val = 0, l2val = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {

                l1 = l1.next;
                len1++;
            }

            if (l2 != null) {
                l2 = l2.next;
                len2++;
            }
        }

        int len = len1 - len2;

        while (l1Tmp != null || l2Tmp != null) {
            l1val = 0;
            l2val = 0;
            if (l1Tmp != null && (len >= 0)) {
                l1val = l1Tmp.val;
                l1Tmp = l1Tmp.next;
                //len1--;
            }

            if (l2Tmp != null && (len <= 0)) {
                l2val = l2Tmp.val;
                l2Tmp = l2Tmp.next;
                //len2--;
            }

            len = len > 0 ? --len : (len == 0 ? len : ++len);

            //numIn = (l1val + l2val) / 10;
            res.next = new ListNode(l1val + l2val);
            res = res.next;
        }
        ListNode res2 = res1;
        res1 = res1.next;
        boolean flag = true;
        int numInFirst = 0;
        while (res1 != null) {
            numIn = 0;
            if (res1.next != null) {
                numIn = res1.next.val / 10;
                res1.next.val = res1.next.val % 10;
            }

            if (flag) {
                numInFirst = (res1.val + numIn) / 10;
            }
            res1.val = (res1.val + numIn) % 10;
            flag = false;
            res1 = res1.next;
        }
        if (numInFirst > 0) {
            return new ListNode(numInFirst, res2.next);
        } else {
            return res2.next;
        }
    }

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(2),
                new ListNode(8,new ListNode(9,new ListNode(9))));
    }

}
