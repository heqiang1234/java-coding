package com.leetcode.sginin;

import com.leetcode.model.Node;

/**
 * @author HQ
 * @program: java-coding
 * @description: 剑指offer.029排序的循环队列
 * @date 2022-06-18 09:45:12
 */
public class Question029JZOFFERinsert {

    public Node insert(Node head, int insertVal) {
        Node res = head;
        while (res != null) {
            if (insertVal > res.val) {
                if (res.next != null) {
                    if (insertVal <= res.next.val) {
                        Node temp = res.next;
                        res.next = new Node(insertVal);
                        res = res.next;
                        res.next = temp;
                        return head;
                    }
                } else if (res.next.val == insertVal) {

                }
            } else if (res.val == insertVal) {
                    Node temp = res;
            }
        }
        return null;

    }
}
