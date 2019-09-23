package leetcode;

public class LeetCode005 {
    /**
     * 5. 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(s.substring(j, len - i + j))) {
                    return s.substring(j, len - i + j);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0, len = s.length(); i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
