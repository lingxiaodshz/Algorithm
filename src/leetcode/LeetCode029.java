package leetcode;

public class LeetCode029 {
    /**
     * 29. 两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * 示例 1:
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 示例 2:
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 说明:
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     */

    public static void main(String[] args) {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(1, 1));
//        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(2147483647, 2));
    }

    public static int divide(int dividend, int divisor) {
        //用减法实现容易超时，思路比较容易理解
//        if (divisor == 0) {
//            return 0;
//        }
//        if (dividend > 0 && divisor > 0 && dividend < divisor) {
//            return 0;
//        }
//        if (dividend < 0 && divisor < 0 && dividend > divisor) {
//            return 0;
//        }
//        int count = 0;
//        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
//            int a = Math.abs(dividend);
//            int b = Math.abs(divisor);
//            while (a - b >= 0) {
//                if (count == Integer.MAX_VALUE) {
//                    return Integer.MAX_VALUE;
//                }
//                count++;
//                a = a - b;
//            }
//            return count;
//        } else {
//            int a = Math.abs(dividend);
//            int b = Math.abs(divisor);
//            while (a - b >= 0) {
//                count--;
//                a = a - b;
//            }
//            return count;
//    }

        // 位移法实现
        if (dividend == 0) {
            return 0;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend ^ divisor) < 0;
        long m = Math.abs((long) dividend);//用long避免dividend=Integer.MIN_VALUE时溢出
        long n = Math.abs((long) divisor);
        long result = 0;
        int i = 31;
        while (i >= 0) {
            if ((m >> i) >= n) {
                result += (1 << i);
                m -= n << i;
            }
            i--;
        }

        return (int) (isNegative ? -result : result);
    }
}
