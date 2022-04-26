package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-26 21:17
 * @description: 744. 寻找比目标字母大的最小字母
 **/
public class Question744NextGreatestLetter {

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0,right = letters.length - 1;
        char res = letters[0];
        while (left<= right){
            int mid = left + (right - left) / 2;
            if (letters[mid] > target){
                res = letters[mid];
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }
}
