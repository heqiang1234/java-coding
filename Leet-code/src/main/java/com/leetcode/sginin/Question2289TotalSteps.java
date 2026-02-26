package com.leetcode.sginin;

public class Question2289TotalSteps {

    public static int totalSteps(int[] nums) {
        int count = 0;
        int len = nums.length;
        // 5,3,4,4,7,3,6,11,8,5,11
        // q,0,q,q,q,0,q,q,0,0,q
        // q,1,0,q,q,1,0,q,1,1,q
        // q,1,1,0,q,1,1,q,1,1,q

        char[] visited = new char[len];
        for (int i = 0; i < len; i++) {
            visited[i] = 'q';
        }
        // 5, 3true,4,4,7
        // 5,
        while (true) {

            int countChange = 0;
            int curNum = nums[0];
            for (int i = 1; i < len; i++) {
                //
                if (curNum > nums[i] && visited[i] == 'q') {
                    visited[i] = '0';
                    countChange++;
                } else {
                    if (visited[i] == '0') {
                        visited[i] = '1';
                    }
                }

                // 判断是否需要更换数字，因为如果之前的那个已经被改变了，则不需要变换
                if (visited[i] != '1') {
                    curNum = nums[i];
                }
            }
            if (countChange == 0) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(totalSteps(new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11}));
        System.out.println(totalSteps(new int[]{4,5,7,7,13}));


    }

}
