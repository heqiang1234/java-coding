package com.leetcode.Algorithm.TwoOrderSearch;

/**
 * @author: Mr.He
 * @create: 2022-04-23 20:16
 * @description: 374.猜数字
 **/
public class Question374GuessNumber {

    public static int numT = 6;

    /**
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 1,right = n;
        while (left < right){
            int mid = left + (right - left) >>1;
            // if (guess(mid) <= 0){
            //     right = mid;
            // } else {
            //     left = mid - 1;
            // }
            if (guess(mid) == 0){
                return mid;
            } else if (guess(mid) == -1){
                right = mid - 1;
            } else if (guess(mid) == 1){
                left = mid + 1;
            }
        }
        return left;
    }


    public static int guess(int num){
        if (num == numT){
            return 0;
        }else if (num < numT){
            return -1;
        } else {
            return 1;
        }
    }

}
