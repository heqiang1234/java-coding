package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/6 17:08
 * @desc 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question53SearchNumber {

    //二分查找
    public int search(int[] nums, int target) {
        return searchTemp(nums,0,nums.length - 1,target);
    }
    public int searchTemp(int[] nums,int left,int right,int target){
        while(left <= right)
        {
            int len = (left + right)>>1;
            if(nums[len] == target){
                return 1 + searchTemp(nums,left,len - 1,target) + searchTemp(nums,len + 1,right,target);
            }else if(nums[len] > target){
                right = len - 1;
            }else{
                left = len + 1;
            }
        }
        return 0;
    }
}
