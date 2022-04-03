package com.leetcode.jianzhioffer;
/*
 * @program: demo
 *
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 *
 * @author: heqiang
 *
 * @create: 2021-12-01 11:05
 */

public class Question22GetKthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {
            val = val;
        }
    }
   
    /**
    * @Description:  直接遍历得到链表
    * @Param: 
    * @return: 
    * @Author: Mr.He
    * @Date: 2021/12/1
    */
    public static ListNode getKthFormEnd(ListNode head, int k) {
        int n=0;
        ListNode curr = null;
        for (curr = head; curr != null ; curr = curr.next) {
            n++;
        }
        for (curr = head; n > k ; n--) {
            curr = curr.next;
        }
        return curr;
    }

    public static  ListNode getKthFornEndFastSlow(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        return slow;
//        ListNode fast = head;
//        ListNode slow = null;
//        while (fast != null) {
//            if(k == 0) {
//                slow = fast;
//            }
//            k--;
//            if(slow != null) {
//                System.out.println(k);
//                slow = slow.next;
//            }
//            fast = fast.next;
//        }
//        return slow;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode();
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length - 1; i++) {
            ListNode temp = new ListNode(nums[i]);
            root.val = nums[i];
            root.next = temp;
        }
        System.out.println();
        getKthFornEndFastSlow(root,2);
    }
}
