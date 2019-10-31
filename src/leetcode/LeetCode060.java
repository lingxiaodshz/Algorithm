package leetcode;

import jdk.nashorn.internal.objects.NativeInt8Array;
import sun.security.util.Length;

public class LeetCode060 {
    /**
     * 60. 第k个排列
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 说明：
     * 给定 n 的范围是 [1, 9]。
     * 给定 k 的范围是[1,  n!]。
     * 示例 1:
     * 输入: n = 3, k = 3
     * 输出: "213"
     * 示例 2:
     * 输入: n = 4, k = 9
     * 输出: "2314"
     */

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 2));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        int a = 0, b = 0, factor = 0;
        for (int i = 0; i < n; i++) {
            factor = factorial(n - i - 1);
            a = k / factor;
            b = k % factor;
            if (a > 0 && a < n - i) {
                if (b == 0) {
                    a = a - 1;
                    b = factor;
                }
                char c = sb.charAt(i + a);
                sb.deleteCharAt(i + a);
                sb.insert(i, c);
                k = b;
            } else if (a == n - i) {
                String sb1 = sb.substring(0, i);
                sb.delete(0, i);
                sb.reverse();
                if (sb1 != null) {
                    sb.insert(0, sb1);
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        int factor = 1;
        for (int i = 2; i <= n; i++) {
            factor *= i;
        }
        return factor;
    }
}
