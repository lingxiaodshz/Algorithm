package leetcode;

import java.util.function.LongFunction;

public class LeetCode069 {
    /**
     * 69. x 的平方根
     * 实现 int sqrt(int x) 函数。
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * 示例 1:
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     */

    public static void main(String[] args) {

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);

        System.out.println(mySqrt(4));

    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long right = x;
        long left = 1;
        long mid = 0;
        long temp = 0;
        while (left < right) {
            mid = (left + right + 1) / 2;
            temp = mid * mid;
            if (temp > x) {
                right = mid - 1;
            } else if (temp < x) {
                left = mid;
            } else{
                return (int) mid;
            }
        }
        return (int) left;
    }
}


