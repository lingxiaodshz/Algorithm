package xiaomi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
示例 1:
输入:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出:
[0,9]
解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。
示例 2:
输入:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
输出:
[]
 */
public class Test02 {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"bar", "foo"};
        showArray(s, words);
        String s1 = "goodwordstudentgoodword";
        String[] words1 = {"word", "student"};
        showArray(s1, words1);
    }

    private static void showArray(String s, String[] words) {
        if (words.length * words[0].length() > s.length()) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        // 减少循环次数
        int temp = 0;
        int subLen = 0;
        boolean flag = false;
        int wordsLen = 0;
        for (String word : words) {
            wordsLen += word.length();
        }
        for (int i = 0; i < s.length() - wordsLen; i++) {
            if (!wordList.isEmpty()) {
                wordList.clear();
            }
            temp = i;
            wordList.addAll(Arrays.asList(words));
            while (!wordList.isEmpty()) {
                // 单词等长可以用这种方式，不等长用下面的方式
//                if (wordList.remove(s.substring(temp, temp + len))) {
//                    temp += len;
//                } else {
//                    break;
//                }
                // wordList集合不为空，去查找里面是否存在符合条件的word，如果不存在则直接跳出while循环
                flag = false;
                for (int j = 0; j < wordList.size(); j++) {
                    subLen = wordList.get(j).length();
                    if (wordList.remove(s.substring(temp, wordList.get(j).length() + temp))) {
                        temp += subLen;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
                if (wordList.isEmpty()) {
                    list.add(i);
                }
            }
        }
        System.out.println(list);
    }
}
