package com.leetcode.all;

import java.util.Arrays;

/**
 * @program: demo
 * @description: leetcode 414. 第三大数
 * @author: Mr.He
 * @create: 2021-12-09 09:26
 **/
public class Question414ThirdMax {

    //正常暴力解法，排序取值
    public static int thirdMax(int[] nums,int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
       // quickSort(nums, 0, nums.length - 1);//快速排序
        Arrays.sort(nums);
        //selectSort(nums);//选择排序
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        //1 2 2 2 3
        int count = 0;
        int MaxValue = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < MaxValue) {
                MaxValue = nums[i];
                count++;
            }
            if (count == k) {
                return MaxValue;
            }
        }
        if (count < k) {
            return nums[nums.length - 1];
        }
        return MaxValue;
    }

    //QuickSort快速排序
    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int tmp = nums[left];//比较的基准数
            while (i < j) {
                while (i < j && nums[j] > tmp) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= tmp) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = tmp;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    //选择排序
    public static void selectSort(int[] nums) {
        int lenNums = nums.length;
        //遍历最外层的数据
        for (int i = 0; i < lenNums; i++) {
            //将当前数据取出来
            int minKey = nums[i];
            //遍历后续是否有
            for (int j = i; j < lenNums; j++) {
                if (minKey > nums[j]) {
                    int tempNum = nums[j];
                    nums[j] = minKey;
                    minKey = tempNum;
                }
            }
            nums[i] = minKey;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(thirdMax(nums,4));
    }
}
