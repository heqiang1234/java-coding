package com.leetcode.all;

import java.util.Scanner;

/**
 * @program: demo
 * @description: 1576. 替换所有的问号
 * @author: Mr.He
 * @create: 2022-01-05 09:15
 **/
public class Question1576ModifyString {

    public static String modifyString(String s) {
        StringBuffer str = new StringBuffer();
        char [] res = s.toCharArray();
        char strTmp = ' ';
        for(int i = 0; i< s.length(); i++){
            if(res[i] == '?') {
                if(i == 0 ) {
                    if(s.length() == 1){
                        strTmp = getDifferent('*','*');
                        str.append(strTmp);
                        res[i] = strTmp;
                    } else{
                        strTmp = getDifferent('*',res[i + 1]);
                        str.append(strTmp);
                        res[i] = strTmp;
                    }
                } else if(i == s.length() - 1){
                    strTmp = getDifferent(res[i -1],'*');
                    str.append(strTmp);
                    res[i] = strTmp;
                } else {
                    strTmp = getDifferent(res[i -1],res[i + 1]);
                    str.append(strTmp);
                    res[i] = strTmp;
                }
            } else {
                str.append(res[i]);
            }
        }
        return str.toString();
    }

    public static char getDifferent(char leftChar,char rightChar){
        char[] allEng = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
                'o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 0; i < allEng.length ; i++){
            if(allEng[i] != leftChar && allEng[i] != rightChar) {
                return allEng[i];
            }
        }
        return 'a';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(modifyString(scanner.next()));
    }
}
