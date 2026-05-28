package com.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * 2021/11/01 heqiang
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Qustion09TwoStackToQueue {

    //想法简单，仅仅将第二个栈当成储存中间值的作用，假设A。B两个栈
    //修改意见，将B栈循环使用，不需要使用完直接清除，可以后续继续判断B栈中是还存在元素，存在则直接取出元素。不需要反复的去将A的元素插入到B中
    //当B中元素取完后，再将A的元素插入到B中，取出B的第一个元素，这样相当于，取元素，就操作B。B取完，就将A的所有元素同步到B，

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Qustion09TwoStackToQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack1.isEmpty()) {
            return -1;
        }

        if (!stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
