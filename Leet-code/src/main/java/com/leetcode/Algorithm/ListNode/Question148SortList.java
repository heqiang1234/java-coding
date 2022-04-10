package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @program: java-coding
 * @description: 148. 排序链表
 * @author: Mr.He
 * @create: 2022-04-10 14:02
 **/
public class Question148SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            map.put(head.val, head);
            head = head.next;
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        ListNode ln = new ListNode(-1);
        ListNode ln1 = ln;
        for (int i = 0; i < res.size(); i++) {
            ln1.next = new ListNode(res.get(i));
            ln1 = ln1.next;
        }
        return ln.next;
    }

    public static ListNode sortList1(ListNode head) {
        ListNode ress = megreList(head, null);
        return ress;// 左闭右开区间，即右边界是最后一个元素的右边，即 null
    }

    public static ListNode megreList(ListNode start, ListNode end) {
        if (start == null) {
            return null;
        }
        if (start.next == end) {
            //左闭右开区间
            start.next = null;
            return start;//由于 end 属于右边那部分的，不关左边事，所以断开连接再返回
        }
        ListNode mid = midListNode(start, end);
        ListNode list1 = megreList(start, mid);
        ListNode list2 = megreList(mid, end);
        ListNode res = mergeListNode(list1, list2);
        return res;
    }

    //获取中点位置
    public static ListNode midListNode(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }

    //合并
    public static ListNode mergeListNode(ListNode head1, ListNode head2) {
        ListNode hd = new ListNode(-1); //新的队列
        ListNode curr = hd;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        curr.next = head1 == null ? head2 : head1;
        return hd.next;
    }

    //归并排序
    //即归并是从中间开始不断分为左右两部分，对左右两部分进行合并排序

    public static void main(String[] args) {
        ListNode res = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        sortList1(res);
    }
}
