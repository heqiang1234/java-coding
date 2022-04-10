package com.leetcode.Algorithm.TreeNode;

/**
 * @program: java-coding
 * @description: 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * @author: Mr.He
 * @create: 2022-04-04 14:56
 **/
public class QuestionJianZhiOfferII027removeNthFromEnd {

    public class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode slow = res;
        ListNode fast = res;
        while (n >= 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return res.next;

    }
}
