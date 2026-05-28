package com.leetcode.wangdaostudylevel2;

import com.leetcode.model.ListNode;

import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 删除链表的倒数第 N 个结点
 * @date 2022-09-01 22:18:42
 */
public class Day3_Qestion19RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1,head);
        ListNode fast = head;
        ListNode slow = res;
        while (n-- > 0){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }

}
