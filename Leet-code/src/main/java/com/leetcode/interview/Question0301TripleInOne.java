package com.leetcode.interview;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 面试题 03.01. 三合一
 * @author: Mr.He
 * @create: 2021-12-09 17:36
 *
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *  
 *
 * 提示：
 *
 * 0 <= stackNum <= 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-in-one-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question0301TripleInOne {

    //想法是用二维数组存储，因为要维护三个栈
    //维护三个栈的索引位置
    //其实可以 stack1:[0,3,6...] , stack2:[1,4,7...] , stack3:[2,5,8...]
    public int[][] nums = null;
    public int[] indexNum = null;

    public class TripleInOne {

        public TripleInOne(int stackSize) {
            //初始化二位数组
            nums = new int[3][stackSize];
            for (int i = 0; i < 3; i++) {
                Arrays.fill(nums[i], Integer.MAX_VALUE);
            }
            indexNum = new int[3];
            Arrays.fill(indexNum,0);
        }

        public void push(int stackNum, int value) {
            if (indexNum[stackNum] <= nums[stackNum].length - 1) {
                if (nums[stackNum][indexNum[stackNum]] == Integer.MAX_VALUE) {
                    nums[stackNum][indexNum[stackNum]++] = value;
                }
            }
        }

        public int pop(int stackNum) {
            for (int i = nums[stackNum].length - 1; i >= 0; i--) {
                if (nums[stackNum][i] != Integer.MAX_VALUE) {
                    int tmp = nums[stackNum][i];
                    nums[stackNum][i] = Integer.MAX_VALUE;
                    indexNum[stackNum]--;
                    return tmp;
                }
            }
            return -1;
        }

        public int peek(int stackNum) {
            for (int i = nums[stackNum].length - 1; i >= 0; i--) {
                if (nums[stackNum][i] != Integer.MAX_VALUE) {
                    return nums[stackNum][i];
                }
            }
            return -1;
        }

        public boolean isEmpty(int stackNum) {
            for (int i = 0; i < nums[stackNum].length; i++) {
                if (nums[stackNum][i] != Integer.MAX_VALUE) {
                    return false;
                }
            }
            return true;
        }
    }

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
}
