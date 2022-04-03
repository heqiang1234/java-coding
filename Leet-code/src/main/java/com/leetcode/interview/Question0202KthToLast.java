package com.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 面试题 02.02. 返回倒数第 k 个节点
 * @author: Mr.He
 * @create: 2021-12-07 16:53
 **/
public class Question0202KthToLast {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        //将链表值存进list
        while (head != null) {
            list.add(head.val);
            System.out.println(head.val);
            head = head.next;
        }
        int count = 0;
        int len = list.size();
        if (k > len) {
            return 0;
        }
        //直接遍历位置，返回结果
        for (int i = len; i > 0; i--) {
            if (count == k) {
                return list.get(i);
            }
            count++;
        }
        return 0;
    }

    //差记性
    //快慢指针
    public static int kthToLastTwo(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        ListNode fast = head;
        ListNode slow = head;
        //将链表值存进list
        while (fast != null) {
            //慢指针要到k为0才开始遍历，这样可以保证间距为2
            if (k > 0) {
                fast = fast.next;
                k--;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(kthToLastTwo(head, 2));

    }
}
