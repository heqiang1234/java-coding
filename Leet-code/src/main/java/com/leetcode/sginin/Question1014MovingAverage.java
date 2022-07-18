package com.leetcode.sginin;

import javax.jnlp.ClipboardService;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HQ
 * @program: java-coding
 * @description: 1014.滑动窗口的平均值
 * @date 2022-07-16 15:32:50
 * <p>
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 成员函数 next 每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["MovingAverage", "next", "next", "next", "next"]
 * inputs = [[3], [1], [10], [3], [5]]
 * 输出：
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * 解释：
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // 返回 1.0 = 1 / 1
 * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qIsx9U
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1014MovingAverage {

    List<Integer> res;
    int sizeNum;
    int nowIndex;//记录当前位置

    /**
     * Initialize your data structure here.
     */
    public Question1014MovingAverage(int size) {
        res = new ArrayList<>();
        sizeNum = size;
        nowIndex = -1;
    }

    public double next(int val) {
        nowIndex++;
        if (nowIndex > 0){
            res.add(val + res.get(nowIndex - 1));
        } else {
            res.add(val);
        }

        if (nowIndex - sizeNum >= 0) {
            return (res.get(nowIndex) - res.get(nowIndex - sizeNum) * 1.0 ) /sizeNum * 1.0;
        } else {
            return res.get(nowIndex) * 1.0 / (nowIndex + 1) * 1.0;
        }

    }

    public static void main(String[] args) {
        Question1014MovingAverage movingAverage = new Question1014MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
