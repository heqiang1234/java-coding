package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

public class QuestionLCRGetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode headAtmp = headA;
        ListNode headBtmp = headB;
        while (headAtmp != headBtmp) {
            headAtmp = headAtmp == null ? headB : headAtmp.next;
            headBtmp = headBtmp == null ? headA : headBtmp.next;
        }
        return headAtmp;
    }

    public static ListNode deleteNode(ListNode headA) {

        ListNode newA = headA;
        while (headA != null) {
            if (headA.next == null){
                break;
            }
            // 1,1,1,2,2,3,3,4
//            if (headA.next.next == null){
//                break;
//            }
            if (headA.val == headA.next.val) {
                headA.next = headA.next.next;
            } else {
                headA = headA.next;
            }
        }
        return headA;
    }

    public static void main(String[] args) {
        deleteNode(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3)))))))));
    }

}
