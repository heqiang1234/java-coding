package com.leetcode.wangdaostudylevel2;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 234.回文链表
 * @date 2022-08-31 23:09:44
 */
public class Day3_Question234IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode midNode = getMidListNode(head);
        ListNode revertNode = revertListNode(midNode);
        while (revertNode != null && head != null){
            if (head.val != revertNode.val){
                return false;
            }
            revertNode = revertNode.next;
            head = head.next;
        }
        return true;
    }

    public ListNode revertListNode(ListNode root){
        ListNode pre = null;
        ListNode curr = root;
        while (curr != null){
            ListNode now = curr.next;
            curr.next = pre;
            pre = curr;
            curr = now;
        }
        return pre;
    }

    public ListNode getMidListNode(ListNode root){
        ListNode fast = root;
        ListNode slow = root;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
