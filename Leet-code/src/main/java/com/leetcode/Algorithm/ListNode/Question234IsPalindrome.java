package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 234.回文链表
 * @date 2022-04-13 22:01:19
 */
public class Question234IsPalindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode first = head;
        ListNode mid = getMidListNode1(first);
        ListNode after = reverList(mid.next);
        Boolean flag = true;
        ListNode p1 = head;
        ListNode p2 = after;
        while (flag && p2 != null) {
            if (p1.val != p2.val) {
                flag = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode af = reverList(after);
        return flag;
    }

    public static ListNode reverList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nd;
        }
        return prev;
    }

    public static ListNode getMidListNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static ListNode getMidListNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        ListNode res = new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(3)))));
        isPalindrome(res);
    }

}
