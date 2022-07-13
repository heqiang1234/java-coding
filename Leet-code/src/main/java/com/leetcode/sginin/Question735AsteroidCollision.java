package com.leetcode.sginin;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author HQ
 * @program: java-coding
 * @description: 735.行星碰撞
 * @date 2022-07-13 21:42:56
 * <p>
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question735AsteroidCollision {

    //二分找到为负号的
    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length - 1;
        int[] res = new int[len];
        int index = binSearch(asteroids);
        if (index == Integer.MAX_VALUE) {
            return res;
        }
        int left = index - 1, right = index;
        while (left >= 0 && right <= len) {
            if (asteroids[left] > Math.abs(asteroids[right])) {
                right++;
            } else if (asteroids[left] < Math.abs(asteroids[right])) {
                left--;
            } else {
                left--;
                right++;
            }
        }
        if (left < 0) {
            if (right > len) {
                return new int[]{};
            } else {
                return indexNum(right, len, asteroids);
            }
        } else {
            if (right > len) {
                return indexNum(0, left, asteroids);
            } else {
                int[] leftNum = indexNum(0, left, asteroids);
                int[] rightNum = indexNum(right, len, asteroids);
                int leftNumL = leftNum.length;
                int rightNumL = rightNum.length;
                int[] ans = new int[leftNumL + rightNumL];
                for (int i = 0; i < leftNumL; i++) {
                    ans[i] = leftNum[i];
                }
                for (int i = 0; i < rightNumL; i++) {
                    ans[leftNumL + i] = rightNum[i];
                }
                return ans;
            }
        }
    }

    public static int[] indexNum(int left, int right, int[] aster) {
        int len = right - left + 1;
        int[] res = new int[len];
        for (int i = left; i <= right; i++) {
            res[i] = aster[i];
        }
        return res;
    }

    public static int binSearch(int[] aster) {
        int left = 0, right = aster.length - 1;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (aster[mid] > 0) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            Boolean flag = false;
            int num = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                while (!stack.isEmpty()){
                    int tempNum = stack.peek();
                    if ((tempNum > 0 && num < 0)) {
                        int jugNum = Math.abs(num) - Math.abs(tempNum);
                        if (jugNum == 0) {
                            stack.pop();
                            break;
                        } else if (jugNum > 0) {
                            stack.pop();
                            //stack.push(num);
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = true;
                       // stack.push(num);
                        break;
                    }
                }
                if (flag){
                    stack.push(num);
                }
            }
        }
        if (stack.isEmpty()) {
            return new int[]{};
        } else {
            int len = stack.size();
            int[] res = new int[len];
            len--;
            while (!stack.isEmpty()) {
                res[len] = stack.pop();
                len--;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] res = asteroidCollision1(new int[]{-2,2,1,-2});
        System.out.println(Arrays.toString(res));
    }

}
