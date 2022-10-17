package com.llabuladongstudy.zero.three;

import com.leetcode.model.ListNode;

/**
 * @author: Mr.He
 * @create: 2022-09-27 10:44
 * @description: 21.合并两个有序链表
 **/
public class Question21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dump = new ListNode(-1),p = dump;
        ListNode l1 = list1,l2 = list2;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                p.next = l1;
                l1.next = l1;
            } else {
                p.next = l2;
                l2.next = l2;
            }
            p = p.next;
        }
        if (l1 != null){
            p.next = l1;
        }
        if (l2!= null){
            p.next = l2;
        }
        return dump.next;
    }

}
