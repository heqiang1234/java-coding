package com.leetcode.jianzhioffer;

/**
 * @author HQ
 * @create 2021/11/6 13:28
 * @desc 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question03FindRepeatNumber {

    //2, 3, 1, 0, 2, 5, 3
    //相当于把nums数组中的 2放进  tmp[2],此时的值就是2的数据，以此类推。当后续有值大于1，则进行返回，中断操作
    //时间复杂度 O(n)
    public static int findRepeatNumber(int[] nums) {
        int res =0;
        int len = nums.length;
        int [] tmp = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            tmp[i] = 0;
        }
        for (int i = 0; i < len ; i++) {
            tmp[nums[i]]++;
            if (tmp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return res;
    }

    //原地修改，同样使用数组的特性
    public static int findRepeatnumber1(int[] nums) {
        int i = 0;
        while (i< nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return  nums[i];
            }
            int tmp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = tmp;
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[]  a= {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatnumber1(a));
    }
    
}
