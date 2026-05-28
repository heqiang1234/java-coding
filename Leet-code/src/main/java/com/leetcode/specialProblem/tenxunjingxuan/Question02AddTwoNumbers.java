package com.leetcode.specialProblem.tenxunjingxuan;


import com.leetcode.model.ListNode;

/**
 * @author: Mr.He
 * @create: 2022-06-09 13:47
 * @end 2022-03-09 14:51
 * @description: 02.两数相加
 **/
public class Question02AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resTemp = new ListNode(0);
        ListNode res = resTemp;
        int upNum = 0;
        while (l1 != null || l2 != null){
            int ans = 0,l1Num = 0,l2Num = 0;
            if (l1 != null){
                l1Num = l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
               l2Num = l2.val;
               l2 = l2.next;
            }
            ans = l1Num + l2Num + upNum;
            if (ans >= 10){
                upNum = ans / 10;
            } else {
                upNum = 0;
            }
            ans = ans %10;
            ListNode nextRes = new ListNode(ans);
            res.next = nextRes;
            res = res.next;
        }
        if (upNum != 0){
            res.next = new ListNode(upNum);
        }
        return resTemp.next;
    }

    public static void main(String[] args) {
        addTwoNumbers(new ListNode(2,new ListNode(4,new ListNode(3))),new ListNode(5,new ListNode(6,new ListNode(4))));
    }
}
