package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @author heqiang
 * @date 2025年11月06日11:07
 */
public class Question1290GetDecimalValue {

    public int getDecimalValue(ListNode head) {

        int sum = 0;
        while (head != null) {
            sum = (sum) * 2 + head.val;
            head = head.next;
        }
        return sum;
    }


}
