package com.leetcode.hotface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author HQ
 * @program: java-coding
 * @description: 32.最长有效括号
 * @date 2022-09-15 23:23:35
 */
public class Question32LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}
