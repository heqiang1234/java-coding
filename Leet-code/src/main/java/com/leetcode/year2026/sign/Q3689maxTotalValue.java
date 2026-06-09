package com.leetcode.year2026.sign;

public class Q3689maxTotalValue {


    public static long maxTotalValue(int[] nums, int k) {

        // 得到最大值和最小值，及其位数，
        int max_index = 0,max_num = Integer.MIN_VALUE;
        int min_index = 0,min_num = Integer.MAX_VALUE;
        int len = nums.length - 1;
        for (int i = 0; i <= len; i++) {
            if (nums[i] > max_num) { max_index = i; max_num = nums[i]; }
            if (nums[i] < min_num) { min_index = i; min_num = nums[i]; }
        }

        int num_len = (len + 1 - Math.abs(max_index - min_index));
        // 统计个数，如果充足，则= max_index - min_index
        if (k >= num_len) {
            return (long)k * (max_num - min_num);
        }
        // 得到此时的和

        long res =  (long)num_len * (max_num - min_num);

        k = k - num_len;

        // 如果不充足，则只能 min_index 往 max_index 靠近，找到那个最小的，这样再组合,直到满足k个数组为止
        while (k > 0){
            int i_index = Math.min(min_index,max_index);
            int j_index = Math.max(max_index,min_index);
            for (int i = i_index; i <= j_index; i++) {
                if (nums[i] > max_num) { max_index = i; max_num = nums[i]; }
                if (nums[i] < min_num) { min_index = i; min_num = nums[i]; }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxTotalValue(new int[]{1, 3, 2}, 2));
        System.out.println(maxTotalValue(new int[]{4, 2, 5, 1}, 3));
    }

}
