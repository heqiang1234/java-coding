package com.leetcode.wangdaostudy;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 21.合并两个有序链表
 * @date 2022-08-11 23:27:21
 */
public class Question03_21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        ListNode prev = res;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                prev.next = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return res.next;
    }

}
