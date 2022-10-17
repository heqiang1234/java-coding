package com.leetcode.daimasuixianglu;

/**
 * @author HQ
 * @program: java-coding
 * @description: 209. 长度最小的子数组
 * @date 2022-10-13 20:15:08
 */
public class Day02_209MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int minSetp = Integer.MAX_VALUE;//定义一个起始值
        int len = nums.length - 1;//数组长度
        int sum = 0;//定义一个和
        int left, right;//左右边界
        //遍历数组，使用while也行
        for (right = 0, left = 0; right <= len; ) {
            sum += nums[right];//加上右边界
            //如果满足 >=的条件，则一直在范围内移动左边界，逼近右边界
            while (sum >= target) {
                 minSetp = Math.min(minSetp, right - left + 1);//计算此时左右边界内元素的个数
                sum -= nums[left];//边界移动，窗口内的值也需要对应缩小
                left++;//移动左边界
            }
            right++;//移动右边界
        }
        return minSetp == Integer.MAX_VALUE ? 0 : minSetp;//如果值没有变，说明不存在，则返回0.
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
