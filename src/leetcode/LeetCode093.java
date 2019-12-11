package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode093 {
    /**
     * 93. 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * 示例:
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     */

    public static void main(String[] args) {
//        List<String> list = restoreIpAddresses("25525511135");
        List<String> list = restoreIpAddresses("010010");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static List<String> restoreIpAddresses(String s) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        List<String> list = new ArrayList<>();
        if (len < 4 || len > 12) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        String str1, str2, str3, str4;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    if (i + j + k < len) {
                        str1 = s.substring(0, i);
                        str2 = s.substring(i, i+j);
                        str3 = s.substring(i + j, i + j + k);
                        str4 = s.substring(i + j + k);
                        if (isValid(str1) && isValid(str2) && isValid(str3) && isValid(str4)) {
                            sb.delete(0, sb.length());
                            sb.append(str1);
                            sb.append(".");
                            sb.append(str2);
                            sb.append(".");
                            sb.append(str3);
                            sb.append(".");
                            sb.append(str4);
                            list.add(sb.toString());
                        }
                    }
                }
            }
        }
        return list;
    }

    private static boolean isValid(String str) {
        if (str.startsWith("0") && str.length() > 1) {
            return false;
        }
        if (Integer.valueOf(str) > 255) {
            return false;
        }
        return true;
    }
}
