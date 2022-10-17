package com.leetcode.daimasuixianglu;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 142.环形链表II
 * @date 2022-10-16 13:33:25
 */
public class Day04_142DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;//快慢指针
            slow = slow.next;
            while (fast == slow){//如果相遇，一定还换
                ListNode start = head;
                ListNode end = fast;
                while (start != end){//如果有还，则一个从相遇点触发，一个从起始点出发，最后会在入环点相遇
                    start = start.next;
                    end = end.next;
                }
                return start;//返回后一次相遇的节点
            }
        }
        return null;
    }
}
