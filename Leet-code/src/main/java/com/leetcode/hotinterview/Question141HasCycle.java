package com.leetcode.hotinterview;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demo
 * @description: 141. 环形链表
 * @author: Mr.He
 * @create: 2022-01-21 10:33
 **/
public class Question141HasCycle {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            set.add(head);
            if (set.contains(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
