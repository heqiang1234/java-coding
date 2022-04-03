package com.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: 面试题 02.01. 移除重复节点
 * @author: Mr.He
 * @create: 2021-12-07 15:09
 **/
public class Question0201RemoveDuplicateNodes {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            val = val;
            next = next;
        }

        ListNode(int val) {
            val = val;
        }
    }

    //直接跳
    public static ListNode removeDuplicateNodes(ListNode head) {
        //如果为空直接返回
        if (head == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null) {
            int val = head.val;
            System.out.println(val);
            if (!map.containsKey(val)) {
                map.put(val, 1);
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return head;
    }


    //双重循环
    public static ListNode removeDuplicateNodes2(ListNode head) {
        //如果为空直接返回
        if (head == null) {
            return null;
        }
        ListNode res = head;
        while (res != null) {
            ListNode res2 = res;
            while (res2.next != null) {
                if(res2.next.val == res.val){
                    res2.next = res2.next.next;
                } else {
                    res2 = res2.next;
                }
            }
            res = res.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode((1)))))));
        removeDuplicateNodes(node);
    }
}
