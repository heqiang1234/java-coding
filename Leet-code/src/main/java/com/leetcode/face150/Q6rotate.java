package com.leetcode.face150;

/**
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class Q6rotate {
    public static void rotate(int[] nums, int k) {
        int len = nums.length - 1; // 获取数组的总长度，进行轮转
        int count = 0, index = 0,newIndex = 1, tempNum = nums[0]; // 定义数字变换的次数
        while (count <= len) {
            if (index == newIndex) {
                index++;
                tempNum = nums[index];
            }
             newIndex = NumChangeIndex(index, k, len);

            int tempNumN = nums[newIndex];
            nums[newIndex] = tempNum;
            index = newIndex;
            tempNum = tempNumN;
            count++;

        }
        System.out.println("ces");
    }

    public static void rotate1(int[] nums, int k) {
        int len = nums.length - 1; // 获取数组的总长度，进行轮转
        int count = 0, index = 0,newIndex = 0, tempNum = nums[0]; // 定义数字变换的次数
        for (int i = 0; i <= len; i++) {
            newIndex = NumChangeIndex(i, k, len);
            nums[newIndex] = tempNum;
            tempNum = nums[newIndex];

        }
    }

    public static int NumChangeIndex(int x, int k, int len) {
        if (x + k > len) {
            x = x + k - len - 1;
        } else {
            return x + k;
        }
        return x;
    }

    public static void main(String[] args) {
        rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
