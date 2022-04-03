package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 02.04. 分割链表
 * @author: Mr.He
 * @create: 2021-12-08 09:18
 **/
public class Question0204PartitionListNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode res = head;
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode lagreHead = large;
        //小于基准数的放在一个链表里面，大于的放在里面，然后连接起来
        while (res != null) {
            if (res.val < x) {
                small.next = res;
                small = small.next;
            } else {
                large.next = res;
                large = large.next;
            }
            res = res.next;
        }
        large.next = null;
        small.next = lagreHead.next;
        return smallHead.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        partition(head, 3);
    }
}
