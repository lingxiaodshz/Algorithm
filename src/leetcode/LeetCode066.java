package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode066 {
    /**
     * 66. 加一
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1:
     * 输入: []
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9, 9, 9}));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        List<Integer> list = new ArrayList<>();
        int temp = 1;
        for (int i = len - 1; i >= 0; i--) {
            temp = digits[i] + temp;
            list.add(0, temp % 10);
            temp = temp / 10;
        }
        if (temp > 0) {
            list.add(0, temp);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
