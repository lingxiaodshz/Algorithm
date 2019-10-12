package leetcode;

public class LeetCode038 {
    /**
     * 38. 报数
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * 注意：整数顺序将表示为一个字符串。
     * 示例 1:
     * 输入: 1
     * 输出: "1"
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     */

    public static void main(String[] args) {
//        System.out.println(countAndSay(1));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = "1";
        for (int i = 1; i < n; i++) {
            str = generateStr(str);
        }
        return str;
    }

    private static String generateStr(String str) {
//        if (str.length() < 2) {
//            return "11";
//        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char c;
        for (int i = str.length() - 2; i >= 0; i--) {
            c = str.charAt(i);
            if (c == str.charAt(i + 1)) {
                count++;
            } else {
                sb.insert(0, str.charAt(i + 1));
                sb.insert(0, count);
                count = 1;
            }
        }
        sb.insert(0, str.charAt(0));
        sb.insert(0, count);
        return sb.toString();
    }
}
