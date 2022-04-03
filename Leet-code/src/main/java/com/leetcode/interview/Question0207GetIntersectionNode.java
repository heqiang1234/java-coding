package com.leetcode.interview;

/**
 * @program: demo
 * @description: leetcode 面试题 02.07.  链表相交
 * @author: Mr.He
 * @create: 2021-12-09 09:33
 **/
public class Question0207GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;//定义一个使用的中间节点
        ListNode curB = headB;
        int lenA = 0;//链表的长度
        int lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        //始终保持curA和lenA 是最长的
        int tmpNum = 0;
        if (lenA > lenB) {
            curA = headA;
            curB = headB;
        } else {
            curA = headB;
            curB = headA;
            tmpNum = lenA;
            lenA = lenB;
            lenB = tmpNum;
        }
        int mid = lenA - lenB;
        //让两者保持相同长度
        while (mid != 0) {
            curA = curA.next;
            mid--;
        }
        //碰到相等的返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
