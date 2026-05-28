package com.leetcode.wangdaostudy;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 876. 链表的中间结点
 * @date 2022-08-16 21:00:55
 */
public class Question04_876MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
//        while (fast.next != null){
//            if (fast.next !=null){
//               fast = fast.next;

//            }
//            slow = slow.next;
//            fast = fast.next
//            if(fast == null){
//                break;
//             }
//        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
