package com.leetcode.model;

/**
 * @author HQ
 * @program: java-coding
 * @description: 链表
 * @date 2022-06-18 10:08:21
 */
public class Node {
    public int val;
    public Node next;
    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
