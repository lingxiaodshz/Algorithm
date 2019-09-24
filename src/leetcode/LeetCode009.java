package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode009 {
    /**
     * 9. 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * 你能不将整数转为字符串来解决这个问题吗？
     */

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(5));
        System.out.println(isPalindrome(55));
        System.out.println(isPalindrome(555));
        System.out.println(isPalindrome(5555));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            List<Integer> list = new ArrayList<>();
            while (x != 0) {
                list.add(x % 10);
                x = x / 10;
            }
            for (int i = 0, len = list.size(); i < len / 2; i++) {
                if (list.get(i) != list.get(len - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
