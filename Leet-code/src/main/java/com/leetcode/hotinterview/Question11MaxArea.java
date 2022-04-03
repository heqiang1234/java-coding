package com.leetcode.hotinterview;

/**
 * @program: demo
 * @description: 11. 盛最多水的容器
 * @author: Mr.He
 * @create: 2022-03-05 17:35
 **/
public class Question11MaxArea {

    //长 * 高 （两者取小的）
    public static int maxArea(int[] height) {
        int maxValue = 0;
        int firstIndex = 0;
        int endIndex = height.length - 1;
        while (endIndex >= firstIndex){
            int area = Math.min(height[firstIndex],height[endIndex]) * (endIndex - firstIndex);
            maxValue = Math.max(area,maxValue);
            if (height[firstIndex] > height[endIndex]){
                endIndex --;
            } else {
                firstIndex++;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int [] res = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(res));
    }
}
