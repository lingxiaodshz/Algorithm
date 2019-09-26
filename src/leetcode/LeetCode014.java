package leetcode;

import javax.management.MXBean;

public class LeetCode014 {
    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     */

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));//"fl"
//        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));//""
        System.out.println(longestCommonPrefix(new String[]{"","b"}));//""
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int mixLen = strs[0].length();
        for (int i = 1, len = strs.length; i < len; i++) {
            if (strs[i].length() < mixLen) {
                mixLen = strs[i].length();
            }
        }
        boolean stop = false;
        for (int i = 0; i < mixLen; i++) {
            for (int j = 1, len = strs.length; j < len; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            } else {
                sb.append(strs[0].charAt(i));
            }
        }
        return sb.toString();
    }
}
