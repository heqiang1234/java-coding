package com.leetcode.sginin;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: java-coding
 * @description: 804. 唯一摩尔斯密码词
 * @author: Mr.He
 * @create: 2022-04-10 13:40
 **/
public class Question804UniqueMorseRepresentations {


    public static int uniqueMorseRepresentations(String[] words) {
        String[] word = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String str : words) {
            StringBuilder temp = new StringBuilder();
            for (char c : str.toCharArray()) {
                int index = c - 'a';
                temp.append(word[index]);
            }
            set.add(temp.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
