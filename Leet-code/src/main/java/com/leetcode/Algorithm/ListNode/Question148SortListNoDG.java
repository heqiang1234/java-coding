package com.leetcode.Algorithm.ListNode;

import com.leetcode.model.ListNode;

/**
 * @program: java-coding
 * @description: 归并排序的非递归方法
 * @author: Mr.He
 * @create: 2022-04-10 18:27
 **/
public class Question148SortListNoDG {
    
    public ListNode SortList(ListNode head){
        if (head == null){
            return head;
        }
        ListNode lenCur = head;
        int headlength = 0;
        while (lenCur != null){
            headlength++;
            lenCur = lenCur.next;
        }
        int indexLength = 1;
        ListNode res = new ListNode(0,head);
        for ( indexLength = 0; indexLength < headlength; indexLength = indexLength * 2) {
            
        }
        return null;
    }
}
