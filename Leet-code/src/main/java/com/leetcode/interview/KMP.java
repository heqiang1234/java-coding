package com.leetcode.interview;

/**
 * @program: demo
 * @description: 测试 KMP
 * @author: Mr.He
 * @create: 2021-12-07 09:50
 **/
public class KMP {

    private int[] next=null;
    private char[] mainAry=null;
    private char[] patternAry=null;

    public KMP(String main,String pattern){

        this.mainAry=new char[main.length()+1];
        this.patternAry=new char[pattern.length()+1];
        System.arraycopy(main.toCharArray(),0,mainAry,1,main.length());
        System.arraycopy(pattern.toCharArray(),0,patternAry,1,pattern.length());
        this.next=new int[pattern.length()+1];
    }
    /**
     * KMP匹配
     * @param pos 从主串起始位置开始
     */
    public int match(int pos){

        if(pos>mainAry.length)
            throw new IndexOutOfBoundsException();
        failFunction();

        int i=pos,j=1;
        while(i<mainAry.length&&j<patternAry.length){
            if(j==0||mainAry[i]==patternAry[j]){
                ++i;
                ++j;
            }else{
                j=next[j];
            }
        }
        if(j>=patternAry.length) return i-patternAry.length+1;
        else return 0;
    }
    /**
     * 匹配串失效函数
     */
    private void failFunction(){
        for (int k = 0; k < next.length; k++) {
            System.out.print(next[k] + " ");
        }
        int i=1,j=0;
        next[1]=0;
        while(i<patternAry.length-1){
            if(j==0||patternAry[i]==patternAry[j]){
                next[++i]=++j;
            }else{
                j=next[j];
            }
        }
        System.out.println(next.length);
        for (int k = 0; k < patternAry.length-1; k++) {
            System.out.print(next[k] + " ");
        }
    }

    public static void initNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        int j = 0;
        for (int i = 1; i < str.length(); i++) {
            j = next[i - 1];
            while (str.charAt(j + 1) != str.charAt(i) && j >= 0 ) {
               j = next[j];
            }
            if(str.charAt(i) == str.charAt(j + 1)) {
                next[i] = j + 1;
            } else {
                next[i] = -1;
            }
        }
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i] + " ");
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

//        KMP kmp=new KMP("acabaabaabcacaabc","abaabcac");
////        System.out.println(kmp.match(1));
        initNext("abcdabd");
    }

}
