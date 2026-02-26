package com.leetcode.face150;

public class Question383canConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length())

            return false;

        int[] ch = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char ch_1 = magazine.charAt(i);
            ch[ch_1 - 'a']++;

        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch_1 = ransomNote.charAt(i);

            if (--ch[ch_1 - 'a'] < 0) return false;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
    }

}
