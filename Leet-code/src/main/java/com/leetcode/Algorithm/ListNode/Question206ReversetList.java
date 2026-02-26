package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @program: java-coding
 * @description: 206. 反转链表
 * @author: Mr.He
 * @create: 2022-04-13 19:12
 **/
public class Question206ReversetList {


    // 1-2-3-4-5
    // 5-4-3-2-1
    //  temp 2->1
    //  head
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next; // 将下一个节点存下后，
            curr.next = prev; // 将当前节点的next指向我们最终反转的那个链表的首届点
            prev = curr; // 将反转链表的首节点，从next提前
            curr = temp; // 将之前存的下一个节点赋值给当前，给下一次循环使用
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode res = new ListNode(-1, new ListNode(1, new ListNode(2)));
        // reverseList(res.next);
    }

}
