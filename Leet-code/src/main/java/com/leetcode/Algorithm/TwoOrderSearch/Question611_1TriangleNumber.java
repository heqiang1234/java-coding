package com.leetcode.Algorithm.TwoOrderSearch;

<<<<<<< HEAD
import java.util.Arrays;

/**
 * @author: Mr.He
 * @create: 2022-06-23 10:32
 * @description: 611. 有效三角形的个数
 **/
public class Question611_1TriangleNumber {

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] == 0)
                    continue;

                int left = i + 1, right = j - 1;
                while (left < right) {
                    int mid = left + right >> 1;
                    if (nums[j] + nums[mid] > nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left == right && nums[right] + nums[j] > nums[i]) res += j - right;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{0,1,1,1}));
=======
/**
 * @author HQ
 * @program: java-coding
 * @description: 611. 有效三角形的个数
 * @date 2022-06-22 22:33:56
 */
public class Question611_1TriangleNumber {

    //我的想法，找第三条边，两边之和大于第三边，两边之差，小于第三条边。
    public int triangleNumber(int[] nums) {

>>>>>>> ba2527421cf0c6a0b31ec653be0cb6a7f59ef779
    }
}
