package com.leetcode.all;

/**
 * @program: demo
 * @description: 剑指 Offer II 027. 回文链表
 * @author: Mr.He
 * @create: 2022-04-03 16:50
 **/
public class Question0207IsPalindrome {

    public static class ListNode {
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

    public static boolean isPalindrome(ListNode head) {

        //先找到中点

        if (head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow;
        fast = slow.next;
        slow.next = null;
        ListNode tempSlow = null;
        while (fast != null){
           tempSlow = fast.next; //将后一个暂时存储
            fast.next = slow; //将中间后一个next，只想mid ,slow
            slow = fast;//移动到下一个位置
            fast = tempSlow;
        }
        ListNode tempRes = slow;
        Boolean flag = true;
        while (head != null){
            if (head != slow){
                flag = false;
                break;
            } else {
                head.next = head;
                slow.next = slow;
            }
        }
        ListNode temp1 = null;
        fast = tempRes.next;
        while (tempRes != null){
            temp1 =  fast.next;
            fast.next = tempRes;
            tempRes = fast;
            fast = temp1;
        }
        temp.next = temp1;
        return flag;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(2,new ListNode(1)))));
        isPalindrome(root);
    }
}
