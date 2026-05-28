package com.leetcode.face150;

// [2,2,1,1,1,2,2]
public class Q5majorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        int major = nums[0];
        // 多数抵消，不一致，则直接消除，用count来控制，当前数字
        for (int i = 1; i < nums.length; i++) {
            // 数值一致，则当前数字的count++
            if (nums[i] == major) {
                count++;
            }   else {
                // 不一致则，之前相同的数字数量--；
                count--;
            }
            // 当数量为-1时，表示之前储存的一致的数字已经使用完，需要取当前不一致的数量，来进行后续的匹配
            if (count == -1){
                major = nums[i];
                count++;
            }
        }
        // 由于多数元素是大于n/2的，所以抵消之后，一定存在数字。
        return major;
    }

    public static void main(String[] args) {
        majorityElement(new int[]{2,1,2,3,2,4,2,2,2,2,2,1,2,1,3,2,4,2});
    }
}
