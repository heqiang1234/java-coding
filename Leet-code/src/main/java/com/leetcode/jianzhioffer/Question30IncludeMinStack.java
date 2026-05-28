package com.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * @author heqiang
 * @date 2021/11/02
 * @desc
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question30IncludeMinStack {

    //定义辅助栈
    Stack<Integer> stack;
    Stack<Integer> stackTemp;

    public Question30IncludeMinStack() {
        stack = new Stack<>();
        stackTemp = new Stack<>();
    }

    //重点
    //存入栈元素时，将小于将要存入的栈元素存一份在辅助栈中，这样可以保证使用min函数时，可以直接取元素，达到O(1)的效果，
    //存入元素时进行判断，q//这样要注意等于辅助栈的元素也要存入。不然后续取最小会出现空的情况
    public void  push(int x) {
        stack.add(x);
        if(stackTemp.isEmpty() || stackTemp.peek() >= x) {
            stackTemp.add(x);
        }
    }

    //注意辅助栈的元素也要取出来
    public void pop() {
        int tempNum = stack.pop();
        if(tempNum == stackTemp.peek()) {
            stackTemp.pop();
        }
    }

    //直接取原来栈的元素即可
    public int top() {
        return stack.peek();
    }

    //取辅助栈的元素
    public int min() {
        return stackTemp.peek();
    }
}
