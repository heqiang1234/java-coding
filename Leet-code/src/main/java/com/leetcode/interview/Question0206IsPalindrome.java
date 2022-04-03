package com.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 面试题 02.06. 回文链表
 * @author: Mr.He
 * @create: 2021-12-08 11:18
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * <p>
 * 输入： 1->2->2->1
 * 输出： true
 *  
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question0206IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //直接进行处理，解决问题，将数据存储进list
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int j = list.size() - 1;
        for (int i = 0; i < list.size()/2 + 1; i++) {
            if (i <= j) {
                if (list.get(i).compareTo(list.get(j)) != 0) {
                    return false;
                }
            }
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        //ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(2,new ListNode(1))));
        ListNode l1 = new ListNode(-129, new ListNode(-129));
        System.out.println(isPalindrome(l1));
    }
}
