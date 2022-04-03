package com.leetcode.all;

import java.util.Stack;

/**
 * @program: demo
 * @description: 71. 简化路径
 * @author: Mr.He
 * @create: 2022-01-06 09:35
 **/
public class Question71SimplifyPath {

    public static String simplifyPath( String path){
        StringBuilder stringBuilder = new StringBuilder("/");
        char[] res = path.toCharArray();
        Stack<String> stack = new Stack();
        int count = 0;
        while (count < res.length) {
            if(res[count] == '/'){
                count++;
            } else {
                int index_count = count;
                while (count < res.length && res[count] != '/'){
                    count++;
                }

                String tempStr = path.substring(index_count,count);
                if(tempStr.equals("..") && !stack.isEmpty()){
                    stack.pop();
                } else if( !tempStr.equals(".") && !tempStr.equals("..")){
                    stack.push(tempStr);
                }
            }
        }
        if (stack.isEmpty()){
            return "/";
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            stringBuilder1.append("/" + stack.get(i));
        }
        return stringBuilder1.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }
}
