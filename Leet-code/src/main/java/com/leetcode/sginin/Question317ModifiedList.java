package com.leetcode.sginin;

import java.util.HashSet;
import java.util.Set;

/**
 * @author heqiang
 * @date 2025年11月05日13:56
 */
public class Question317ModifiedList {


    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer> hsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hsSet.add(nums[i]);
        }
        ListNode dummy = new ListNode(-1, head);
        //pre.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode nxt = cur.next;
            if (hsSet.contains(nxt.val)) {
                //pre = pre.next;
                cur.next = nxt.next;
            } else {
                //
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        modifiedList(new int[]{1}, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(4)))));
    }
}
