package com.leetcode.sginin;

import org.apache.commons.lang.enums.Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1200.绝对值差最小
 * @date 2022-07-04 21:37:32
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-absolute-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1200MinimumAbsDifference {

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int len = arr.length - 1, maxValue = Integer.MAX_VALUE;
        int nowNum = 0,numNext = 0;
        while (numNext <= len){
            numNext = nowNum + 1;
            int numT = Math.abs(arr[nowNum] - arr[numNext]);
            if (numT < maxValue) {
                res.clear();
                maxValue = numT;
                List<Integer> tempList = new ArrayList<>();
                tempList.add(arr[nowNum]);
                tempList.add(arr[numNext]);
                res.add(tempList);
            } else if (numT == maxValue) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(arr[nowNum]);
                tempList.add(arr[numNext]);
                res.add(tempList);
            }
            nowNum++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4, 2, 1, 3}));
    }

}
