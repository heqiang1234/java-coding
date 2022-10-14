package com.leetcode.daimasuixianglu;

/**
 * @author HQ
 * @program: java-coding
 * @description: 704.二分查找
 * @date 2022-10-12 21:23:12
 */
public class Day01_Search {

    //左闭右闭
    public static int search(int[] nums, int target){
        //首先因为数组是有序的，然后是查找元素，所以可以定位成使用二分
        int left = 0;//起始左边界
        int right = nums.length - 1;//起始右边界
        while (right >= left){//当left == right 时候跳出循环
            int mid = 0;//这里是避免越界的一种写法，等同于 （left / 2 + right /2）
            mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;//存在，返回目标值的位置
            } else if (nums[mid] > target){
                //当中间值大于目标值，说明此时的目标值一定在mid的左侧，所以需要缩小有边界到mid以下，即mid - 1
                right = mid - 1;
            } else {
                //当中间值小于目标值，说明此时的目标值一定在mid的右侧，所以需要移动左边界至mid + 1
                left = mid + 1;
            }
        }
        return -1;//不存在，则返回-1
    }

    public static int searchTwo(int[] nums, int target){
        //首先因为数组是有序的，然后是查找元素，所以可以定位成使用二分
        int left = 0;//起始左边界
        int right = nums.length;//起始右边界
        while (right > left){//当left == right 时候跳出循环
            int mid = left + (right - left) / 2;//这里是避免越界的一种写法，等同于 （left / 2 + right /2）
            if (nums[mid] == target){
                return mid;//存在，返回目标值的位置
            } else if (nums[mid] > target){
                //当中间值大于目标值，说明此时的目标值一定在mid的左侧，所以需要缩小有边界到mid以下，即mid
                right = mid;
            } else {
                //当中间值小于目标值，说明此时的目标值一定在mid的右侧，所以需要移动左边界至mid + 1
                left = mid + 1;
            }
        }
        return -1;//不存在，则返回-1
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4}, 3));
    }
}
