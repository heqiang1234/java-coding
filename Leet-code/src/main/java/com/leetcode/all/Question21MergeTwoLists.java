package com.leetcode.all;

/**
 * @program: demo
 * @description: 21. 合并两个有序链表
 * @author: Mr.He
 * @create: 2022-03-30 22:48
 **/
public class Question21MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev .next = list1 == null ? list2 : list1;
        return prevHead.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val){
            list1.next = mergeTwoLists1(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1,list2.next);
            return list2;
        }
    }
}
