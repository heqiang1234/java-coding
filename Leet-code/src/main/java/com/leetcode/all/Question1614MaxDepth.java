package com.leetcode.all;

import java.util.Stack;

/**
 * @program: demo
 * @description: 1614. 括号的最大嵌套深度
 * @author: Mr.He
 * @create: 2022-01-07 09:40
 **/
public class Question1614MaxDepth {

    public static int maxDepth(String s){
        Stack stack = new Stack();
        int count = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            } else if (s.charAt(i) == ')'){
                if (!stack.isEmpty()){
                    total = Math.max(stack.size(),total);
                    stack.pop();
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
    }
}
