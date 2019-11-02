package leetcode;

public class LeetCode067 {
    /**
     * 67. 二进制求和
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。
     * 输入为非空字符串且只包含数字 1 和 0。
     * 示例 1:
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (a.length() > b.length()) {
            sb1.append(a);
            sb2.append(b);
        } else {
            sb1.append(b);
            sb2.append(a);
        }
        for (int i = 0, len = sb1.length() - sb2.length(); i < len; i++) {
            sb2.insert(0, 0);
        }
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int m = 0;
        int n = 0;
        for (int len = sb1.length(), i = len - 1; i >= 0; i--) {
            m = sb1.charAt(i) - '0';
            n = sb2.charAt(i) - '0';
            temp = m + n + temp;
            sb.insert(0, temp % 2);
            temp = temp / 2;
        }
        if (temp > 0) {
            sb.insert(0, temp);
        }
        return sb.toString();
    }
}
