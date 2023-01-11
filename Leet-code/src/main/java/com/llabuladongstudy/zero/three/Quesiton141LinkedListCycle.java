package com.llabuladongstudy.zero.three;

import com.leetcode.model.ListNode;

/**
 * @author: Mr.He
 * @create: 2022-09-27 10:15
 * @description: 141. 环形链表
 **/
public class Quesiton141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}
