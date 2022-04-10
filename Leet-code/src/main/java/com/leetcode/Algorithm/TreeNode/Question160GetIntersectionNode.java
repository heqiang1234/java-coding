package com.leetcode.Algorithm.TreeNode;

/**
 * @program: java-coding
 * @description: 160. 相交链表
 * @author: Mr.He
 * @create: 2022-04-04 13:51
 **/
public class Question160GetIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x,ListNode next){
            this.next = next;
            this.val = val;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len = 0; //记录链表差值

        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != null){
            cur1 = cur1.next;
            len ++;
        }
        while (cur2 != null){
            cur2 = cur2.next;
            len--;
        }
        System.out.println(len);
        cur1 = len > 0 ? headA : headB;
        cur2 = len < 0 ? headA : headB;
        len = Math.abs(len);
        while (cur1 != null && cur2 != null){
            if (cur1 == cur2){
                return cur1;
            }
            if (len > 0){
                cur1 = cur1.next;
                len--;
            } else {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode cur2 = headA;
        ListNode headB = new ListNode(1);
        ListNode cur1 = headB;
        ListNode h1 = new ListNode(2);
        cur1.next = h1;
        ListNode h2 = new ListNode(4);
        cur1.next.next = h2;
        cur2.next = new ListNode(9);
        cur2.next.next = new ListNode(1);
        cur2.next.next.next  = h1;
        cur2.next.next.next.next = h2;
        System.out.println(getIntersectionNode(headA, headB));
    }
}
