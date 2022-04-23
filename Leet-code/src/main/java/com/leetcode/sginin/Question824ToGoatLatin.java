package com.leetcode.sginin;

/**
 * @program: java-coding
 * @description: 824.山羊拉丁文
 * @author: Mr.He
 * @create: 2022-04-21 19:59
 **/
public class Question824ToGoatLatin {

    public  static  int leve = 0;
    public static String chars = "a,e,i,o,u";
    public static String toGoatLatin(String sentence) {
        StringBuilder str = new StringBuilder();
        int len = sentence.length();
        for (int i = 0; i < len;) {
            int lenCh = 0;
            int start = i;
            while (i <= len - 1 && sentence.charAt(i) != ' ' ){
                lenCh++;
                i++;
            }
            leve++;
            str.append(changeStr(sentence.substring(start,start + lenCh),leve));
            if (i >= len){
                break;
            }
            if (sentence.charAt(i) == ' '){
                str.append(" ");
            }
            i++;
        }
        return str.toString();
    }

    public static String getSizeA(int num){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < num; i++) {
            str.append('a');
        }
        return str.toString();
    }
    
    public static String changeStr(String s,int n){
        int len = s.length();
        if (len <= 0){
            return "";
        }
        StringBuilder str = new StringBuilder();
        if (chars.contains(String.valueOf(s.charAt(0)))){
            str.append(s);
        } else {
            for (int i = 1; i < s.length(); i++) {
                str.append(s.charAt(i));
            }
            str.append(s.charAt(0));
        }
        str.append("ma");
        str.append(getSizeA(n));
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }

}
