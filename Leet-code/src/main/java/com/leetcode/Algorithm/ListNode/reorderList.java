package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class reorderList {

    public static void reorderList(ListNode head) {
        Map<Integer, ListNode> storeNode = new HashMap<>();
        ListNode res = head;
        int i = 0;
        while (res != null) {
            storeNode.put(i++, res);
            res = res.next;
        }

        int j = 0;
        i = storeNode.size() - 1;
        while (i > j){
            storeNode.get(j).next = storeNode.get(i);
            j++;
            if (i == j){
                break;
            }
            storeNode.get(i).next = storeNode.get(j);
            i--;
        }
        storeNode.get(j).next = null;



            return;
    }

    public static void main(String[] args) {
        reorderList(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))));
    }
}
