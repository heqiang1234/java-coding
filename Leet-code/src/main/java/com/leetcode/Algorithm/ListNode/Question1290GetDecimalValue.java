package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

public class Question1290GetDecimalValue {

    public static int getDecimalValue(ListNode head) {
        int count = 0;
        int res = 0;
        while (head != null)
        {
            res += reNum(head.val,count++);
            head = head.next;
        }
        return res;
    }

    public static int reNum(int num,int count){
        int res = 1;
        if (num == 0){
            return 0;
        }
        if (num == 0 && count == 0){
            return 1;
        }
        for (int i = 0; i < count; i++) {
            res = res* 2;
        }
        return res;
    }

    public static void main(String[] args) {
        getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3)))))))));

    }
}
