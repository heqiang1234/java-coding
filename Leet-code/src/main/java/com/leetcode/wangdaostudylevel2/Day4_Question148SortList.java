package com.leetcode.wangdaostudylevel2;

import com.leetcode.model.ListNode;

/**
 * @author HQ
 * @program: java-coding
 * @description: 148.排序链表
 * @date 2022-08-29 22:37:40
 */
public class Day4_Question148SortList {

    public ListNode sortList(ListNode head) {
        return mergeList(head,null);
    }

    //归并排序
    public ListNode mergeList(ListNode start,ListNode end){
        if (start == null){
            return null;
        }
        if (start.next == end){
            start.next = null;
            return start;
        }
        ListNode midNode = getMid(start,end);
        ListNode list1 = mergeList(start,midNode);
        ListNode list2 = mergeList(midNode,end);
        ListNode res = getMgNode(list1,list2);
        return res;
    }

    public ListNode getMgNode(ListNode list1,ListNode list2){
        ListNode hd = new ListNode(-1);
        ListNode curr = hd;
        while (list1 != null && list2 != null){
            if (list1.val >= list2.val){
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
        }
        curr.next = list1 == null ? list2 : list1;
        return hd.next;
    }

    public ListNode getMid(ListNode root,ListNode tail){
        ListNode fast = root;
        ListNode slow = root;
        while (fast.next != tail){
            fast = fast.next;
            slow = slow.next;
            if (fast.next != tail){
                fast = fast.next;
            }
        }
        return slow;
    }

}
