package com.leetcode.sginin;

public class Quesiton1356SortByBits {

    public int[] sortByBits(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (judgeBig(nums[i], nums[j]) > 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    // 1多，则大，1相等，则比原本数字。
    // -1 num1 < num2
    // 0 num1 == num2
    // 1 num1 > num2
    public int judgeBig(int num1, int num2) {
        if (num1 == num2) return 0;
        int c1 = bitSum(num1);
        int c2 = bitSum(num2);
        if (c1 == c2) {
            return num1 > num2 ? 1 : -1;
        } else {
            return c1 > c2 ? 1 : -1;
        }
    }

    public int bitSum(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) count++;
            num = num / 2;
        }
        return count;
    }

    public static int maxScore(String s) {
        int len = s.length();
        int[] numL = new int[len];
        int[] numR = new int[len];
        int left0 = 0, right1 = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') left0++;
            numL[i] = left0;
            if (s.charAt(len - i - 1) == '1') right1++;
            numR[len - i - 1] = right1;
        }
        int maxN = 0;
        for (int i = 0; i < len - 1; i++) {
            if (numL[i] + numR[i + 1] > maxN) {
                maxN = numL[i] + numR[i + 1];
            }
        }
        return maxN;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }
}
