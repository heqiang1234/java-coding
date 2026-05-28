package com.leetcode.Algorithm.TwoOrderSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.He
 * @create: 2022-07-06 15:36
 * @description: 651.K个最接近的元素
 * <p>
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question651_1FindClosestElements {

    //确实，删除 size - k 个数字
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        int removeNum = len - k;
        int left = 0, right = len - 1;
        while (removeNum > 0) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
            removeNum--;
        }
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    //二分查找这个边界？
    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        for (int i = left; i <= left + k; i++) {

        }
        return res;
    }

    public static void main(String[] args) {
        findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
    }
}
