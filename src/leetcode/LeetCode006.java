package leetcode;

import java.util.HashMap;

public class LeetCode006 {
    /**
     * 6. Z 字形变换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */

    public static String convert(String s, int numRows) {
        if (s == null || "".equals(s) || s.length() == 1 || numRows == 1) {
            return s;
        }
        HashMap<Integer, StringBuilder> map = new HashMap<>(numRows);
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }
        int n = 2 * numRows - 2;
        int temp;
        for (int i = 0, len = s.length(); i < len; i++) {
            temp = i % n;
            if (temp < numRows) {
                map.get(temp).append(s.charAt(i));
            } else {
                map.get(n - temp).append(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(map.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }
}
