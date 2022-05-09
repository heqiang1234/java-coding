package com.leetcode.sginin;

/**
 * @author: Mr.He
 * @create: 2022-05-09 16:02
 * @description: 942. 增减字符串匹配
 **/
public class Question942DiStringMatch {

    public static int[] diStringMatch(String s) {
        int[] nums = new int[s.length() + 1];
        int i = 0;
        int minNum = 0;
        int maxNum = s.length();
        for (char ch : s.toCharArray()) {
            if (ch == 'D') {
                nums[i] = maxNum;
                maxNum--;
            } else if (ch == 'I') {
                nums[i] = minNum;
                minNum++;
            }
            i++;
            //nums[i] = flag ? temp + 1 : temp - 1;
        }
        nums[i] = maxNum;
        return nums;
    }

    public static void main(String[] args) {
        diStringMatch("DDI");
    }
}
