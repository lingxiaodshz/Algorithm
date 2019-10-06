package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode030 {
    /**
     * 30. 串联所有单词的子串
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     * 示例 1：
     * 输入：
     *   s = "barfoothefoobarman",
     *   words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     * 输入：
     *   s = "wordgoodgoodgoodbestword",
     *   words = ["word","good","best","word"]
     * 输出：[]
     */

    public static void main(String[] args) {
//        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return list;
        }
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        List<String> tempList = new ArrayList<>(Arrays.asList(words));
        for (int i = 0, len = s.length() - totalLen + 1; i < len; i++) {
            for (int j = 0; j < words.length; j++) {
                if (!tempList.remove(s.substring(i + j * wordLen, i + (j + 1) * wordLen))) {
                    break;
                }
            }
            if (tempList.size() == 0) {
                list.add(i);
            }
            tempList = new ArrayList<>(Arrays.asList(words));
        }
        return list;
    }
}
