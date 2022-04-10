package com.leetcode.model;

/**
 * @program: java-coding
 * @description: 链表模板
 * @author: Mr.He
 * @create: 2022-04-10 13:59
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
