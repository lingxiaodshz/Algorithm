package leetcode;

public class LeetCode043 {
    /**
     * 43. 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("10", "10"));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String s1, s2;
        if (num1.length() > num2.length()) {
            s1 = num1;
            s2 = num2;
        } else {
            s1 = num2;
            s2 = num1;
        }
        String num = "0";
        StringBuilder sb;
        for (int len = s2.length(), i = len - 1; i >= 0; i--) {
            sb = mul(s1, s2.charAt(i));
            for (int j = i; j < len - 1; j++) {
                sb.append(0);
            }
            num = add(num, sb.toString());
        }
        return num;
    }

    private static StringBuilder mul(String num1, char c) {
        StringBuilder sb = new StringBuilder();
        int bit = 0;
        for (int len = num1.length(), i = len - 1; i >= 0; i--) {
            int m = c - '0';
            int temp;
            if (m == 0) {
                sb.append(bit);
                bit = 0;
            } else {
                int n = num1.charAt(i) - '0';
                temp = n * m + bit;
                if (temp > 9) {
                    sb.append(temp % 10);
                    bit = temp / 10;
                } else {
                    sb.append(temp);
                    bit = 0;
                }
            }
        }
        if (bit > 0) {
            sb.append(bit);
        }
        return sb.reverse();
    }

    private static String add(String num1, String num2) {
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }
        String s1, s2;
        if (num1.length() > num2.length()) {
            s1 = num1;
            s2 = num2;
        } else {
            s1 = num2;
            s2 = num1;
        }
        StringBuilder sb = new StringBuilder();
        int temp, bit = 0;
        for (int len1 = s1.length(), len2 = s2.length(), i = 1; i <= len2; i++) {
            char c1 = s1.charAt(len1 - i);
            char c2 = s2.charAt(len2 - i);
            int n1 = c1 - '0';
            int n2 = c2 - '0';
            temp = n1 + n2 + bit;
            sb.append(temp % 10);
            bit = temp / 10;
        }
        if (s1.length() - s2.length() == 0) {
            if (bit > 0) {
                sb.append(bit);
            }
        } else {
            for (int i = 1, len = s1.length() - s2.length(); i <= len; i++) {
                char c = s1.charAt(len - i);
                int n = c - '0';
                temp = n + bit;
                sb.append(temp % 10);
                bit = temp / 10;
            }
            if (bit > 0) {
                sb.append(bit);
            }
        }
        return sb.reverse().toString();
    }



}
