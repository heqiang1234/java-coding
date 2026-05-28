package com.llabuladongstudy.zero.three;

import com.leetcode.model.ListNode;

/**
 * @author: Mr.He
 * @create: 2022-09-27 13:41
 * @description: 86.分解链表
 **/
public class Question86Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode dump1 = new ListNode(-1),p1 = dump1;
        ListNode dump2 = new ListNode(-1),p2 = dump2;
        ListNode l1 = head;
        while (l1 != null){
            if (l1.val >= x){
                p2.next = l1;
                p2 = p2.next;
            } else {
                p1.next = l1;
                p1 = p1.next;
            }
            ListNode temp = l1.next;
            l1.next = null;
            l1 = temp;
        }
        p1.next = dump2.next;
        return dump1.next;
    }

}
