package com.leetcode.interview;

/**
 * @program: demo
 * @description: 面试题 02.05. 链表求和
 * @author: Mr.He
 * @create: 2021-12-08 10:45
 * <p>
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question0205AddTwoNumbers {
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

    //反向存放
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //如果一个为空，就返回对应不为空的那个链表，如果都为空，那就随意返回哪个
        while (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode l3Head = l3;
        int bit = 0;//表示进位
        int l1Val = 0;//l1的节点值
        int l2Val = 0;//l2的节点值
        int l3Val = 0;//l3的节点值
        while (l1 != null || l2 != null) {
            l1Val = 0;
            l2Val = 0;
            l3Val = 0;
            //这里要判断哪个链表先使用完，所以要判断是否为空
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            //这里判断新生成的值，和判断是否进位
            l3Val = (l1Val + l2Val + bit) % 10;
            bit = (l1Val + l2Val + bit) / 10;

            ListNode tmp = new ListNode(l3Val);
            l3.next = tmp;
            l3 = l3.next;
            //假设l1,l2都用完了，还是要判断是否还有进位的存在，如果有，那就要添加节点，给进位得值
            if (l1 == null && l2 == null && bit > 0) {
                ListNode tmpLast = new ListNode(bit);
                l3.next = tmpLast;
                l3 = l3.next;
            }
        }
        return l3Head.next;
    }

    //正向存放
    // 6->2->3    5->9->9    1->2->2->2
    public static ListNode addTwoNumbersOne(ListNode l1, ListNode l2) {
        //如果一个为空，就返回对应不为空的那个链表，如果都为空，那就随意返回哪个
        while (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode l3Head = l3;
        int bit = 0;//表示进位
        int l1Val = 0;//l1的节点值
        int l2Val = 0;//l2的节点值
        int l3Val = 0;//l3的节点值
        int count = 0;//计数器，第一位是特殊的，取本身的值
        while (l1 != null || l2 != null) {
            l1Val = 0;
            l2Val = 0;
            l3Val = 0;
            //这里要判断哪个链表先使用完，所以要判断是否为空
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }

            //6->2->3    7->9->9    1->4->2->2
            //这里判断新生成的值，和判断是否进位
            //l3Val = (l1Val + l2Val + bit) % 10;//这个表示当前位的值
            if (count == 0) {
                if ((l1Val + l2Val + bit) >= 10) {
                    l3Val = (l1Val + l2Val + bit) / 10;
                    bit = (l1Val + l2Val + bit) % 10;
                } else {
                    l3Val = l1Val + l2Val + bit;
                    bit = 0;
                }
                count++;
            } else {
                if ((l1Val + l2Val + bit) >= 10) {
                    l3Val = (l1Val + l2Val + bit) % 10;
                    bit = (l1Val + l2Val + bit) / 10;
                } else {
                    l3Val = l1Val + l2Val + bit;
                    bit = 0;
                }
            }
//            if ((l1Val + l2Val + bit) >= 10) {
//                l3Val = (l1Val + l2Val + bit) / 10;
//                bit = (l1Val + l2Val + bit) % 10;
//            } else {
//                l3Val = l1Val + l2Val + bit;
//                bit = 0;
//            }
            //这个进位是后面计算时，需要叠加的值
            ListNode tmp = new ListNode(l3Val);
            l3.next = tmp;
            l3 = l3.next;
            //假设l1,l2都用完了，还是要判断是否还有进位的存在，如果有，那就要添加节点，给进位得值
            if (l1 == null && l2 == null && bit > 0) {
                ListNode tmpLast = new ListNode(bit);
                l3.next = tmpLast;
                l3 = l3.next;
            }
        }
        return l3Head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(7, new ListNode(9, new ListNode(9)));
        addTwoNumbersOne(l1, l2);
    }
}
