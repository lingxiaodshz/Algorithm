package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode017 {
    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * 注意：此题主要是弄懂题目意思，只有一个数字，则将数字转化的字符串拆分，如果有多个数字，则每个组合跟数字位数一样
     */

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));//["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        System.out.println(letterCombinations("2"));//["a","b","c"]
        System.out.println(letterCombinations("7"));//["a","b","c"]
        System.out.println(letterCombinations("234"));//["adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi"]
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        while (digits.length() > 0) {
            if (list.size() == 0) {
                list.addAll(Arrays.asList(charToString(digits.charAt(0)).split("")));
            } else {
                List<String> tempList = new ArrayList<>(list);
                list.clear();
                for (int i = 0, len = tempList.size(); i < len; i++) {
                    String tempStr = charToString(digits.charAt(0));
                    for (int j = 0; j < tempStr.length(); j++) {
                        list.add(tempList.get(i) + tempStr.charAt(j));
                    }
                }
            }
            digits = digits.substring(1);
        }
        return list;
    }

    private static String charToString(char c) {
        StringBuilder sb = new StringBuilder();
        if (c >= '2' && c <= '6') {
            sb.append((char) ((c - '2') * 3 + 'a'));
            sb.append((char) ((c - '2') * 3 + 'b'));
            sb.append((char) ((c - '2') * 3 + 'c'));
        } else if (c == '7') {
            sb.append("pqrs");
        } else if (c == '8') {
            sb.append("tuv");
        } else if (c == '9') {
            sb.append("wxyz");
        }
        return sb.toString();
    }
}
