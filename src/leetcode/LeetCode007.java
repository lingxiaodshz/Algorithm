package leetcode;

import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode007 {
    /**
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        boolean isNega = false;
        if (x < 0) {
            isNega = true;
        }
        while (x != 0) {
            list.add(Math.abs(x % 10));
            x = x / 10;
        }
        long temp = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            temp = temp * 10 + iterator.next();
            iterator.remove();
        }
        if (isNega) {
            temp = -temp;
            if (temp < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) temp;
        } else {
            if (temp > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) temp;
        }
    }

    public static void main(String[] args) {
        reverse(-123);
    }
}
