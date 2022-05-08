package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-05-06 22:43
 * @description: 611. 有效三角形的个数
 *
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 *
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-triangle-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question611TriangleNumber {

    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[j] - nums[i] < nums[k]){
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        triangleNumber(new int[]{2,2,3,4});
    }

    public static int binarySearch(int[] nums,int max,int min){
        return 0;
    }
}
