package com.leetcode.wangdaostudylevel2;

/**
 * @author: Mr.He
 * @create: 2022-09-27 09:09
 * @description: 416.分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Day13_Question416CanPartition {

    public boolean flag = false;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum / 2 != Math.floor(sum / 2)){
            return false;
        }


        return true;
    }

    public void dp(int[] nums,int index,int target,int sum){
        if (sum == target){
            flag = true;
            return;
        }
        if (sum > target){
            return;
        }
        dp(nums,index + 1,target, sum + nums[index]);
    }

}
