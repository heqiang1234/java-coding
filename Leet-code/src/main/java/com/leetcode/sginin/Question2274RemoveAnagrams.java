package com.leetcode.sginin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2274RemoveAnagrams {

    public static List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        String wd = words[0];
        int firstIndex = 1;
        for (int i = 1; i < words.length; i++) {
            // 异位 加入 res
            if (!judgeStr(wd, words[i])) {
                wd = words[i];
                words[firstIndex++] = words[i];
                //res.add(wd);
                // firstIndex++;
            }
        }


        return Arrays.asList(Arrays.copyOf(words, firstIndex));
    }

    public static boolean judgeStr(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
    }

}
