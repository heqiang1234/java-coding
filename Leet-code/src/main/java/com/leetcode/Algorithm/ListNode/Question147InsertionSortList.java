package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @program: java-coding
 * @description: 147. 对链表进行插入排序
 * @author: Mr.He
 * @create: 2022-04-10 16:36
 **/
public class Question147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        return mergeList(head,null);
    }

    public ListNode mergeList(ListNode start, ListNode end) {
        if (start == null) {
            return start;
        }
        if (start.next == end) {
            start.next = null;
            return start;
        }
        ListNode mid = getMidListNode(start, end);
        ListNode list1 = mergeList(start, end);
        ListNode list2 = mergeList(mid, end);
        ListNode res = mergeListNode(list1, list2);
        return res;
    }

    //获取到中间节点//使用快慢指针
    public ListNode getMidListNode(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
        }
        curr.next = head1 == null ? head2 : head1;
        return head.next;
    }
}
