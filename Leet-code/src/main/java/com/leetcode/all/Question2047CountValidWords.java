package com.leetcode.all;

/**
 * @program: demo
 * @description: 2047. 句子中的有效单词数
 * @author: Mr.He
 * @create: 2022-01-27 15:57
 **/
public class Question2047CountValidWords {

    public static int countValidWords(String sentence) {
        int[] nums = new int[sentence.length()];
        char[] chars = sentence.toCharArray();
        int[] charBiaoDian = {'!', ',', '.'};
        int[] charZiFu = {'-'};
        int count = 0;
        int maxChar = 0;
        //记录下每个空格的位置
        nums[0] = 0;
        for (int i = 0, j = 1; i < chars.length; i++) {
            if (chars[i] == ' ') {
                while (chars[i] != ' '){

                }
                nums[j] = i;
                j++;
                maxChar++;
            }
        }

        for (int i = 0; i < maxChar; i++) {
            int index = nums[i];
            int currBiaoDian = 0;
            int currZiFu = 0;
            int currNum = 0;
            int currChar= 0;
            for (int j = index; j < nums.length; j++) {
                if (chars[j] == ' ') {
                    count++;
                    break;
                } else {
                    if (chars[j] <= '9' && chars[j] >= '0') {
                        break;
                    } else if (chars[j] == '!' || chars[j] == '.' || chars[j] == ',') {
                        currBiaoDian++;
                    } else if (chars[j] == '-') {
                        currZiFu++;
                    } else {
                        currChar++;
                    }
                }


                if (currBiaoDian > 1 || currZiFu > 1){
                    break;
                }
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countValidWords(""));
    }


}
