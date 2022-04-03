package com.leetcode.jianzhioffer;

/**
 * @program: demo
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * @author: Mr.He
 * @create: 2021-12-01 17:36
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question25MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0),cur = l3;
        System.out.println(l1.val);
        while (l1 != null || l2 != null) {
            System.out.println(cur.val);
            if(l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
            } else if (l1 != null && l2 == null) {
                    cur.next = l1;
                    l1 = l1.next;

            } else if (l1 == null && l2 != null) {
                    cur.next = l2;
                    l2 = l2.next;
            } else {
                break;
            }
            cur = cur.next;
        }
        return l3.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(),curL1 = l1;
        ListNode l2 = new ListNode(),curL2 = l2;
        int [] numL1 = {1,2,4};
        for (int i = 0; i < numL1.length; i++) {
            ListNode temp = new ListNode(numL1[i]);
            l1.next = temp;
            l1 = l1.next;
        }
        System.out.println(l1.val);
//        int [] numL2 = {1,3,4};
//        for (int i = 0; i < numL2.length; i++) {
//            ListNode temp = new ListNode(numL2[i]);
//            //curL2.val = numL2[i];
//            curL2.next = temp;
//        }
        System.out.println(l1.val + " " +curL1);
        System.out.println(l2 + " " +curL2);
        System.out.println(mergeTwoLists(l1,l2));
    }
}
